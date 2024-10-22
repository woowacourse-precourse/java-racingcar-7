package racingcar;

import racingcar.controller.MainController;
import racingcar.repository.CarMemoryRepository;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.service.GameService;
import racingcar.service.GameServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    public MainController mainController() {
        CarRepository carRepository = carRepository();
        return new MainController(carService(carRepository), gameService(carRepository), inputView());
    }


    public CarService carService(CarRepository carRepository) {
        return new CarServiceImpl(carRepository);
    }

    public GameService gameService(CarRepository carRepository) {
        return new GameServiceImpl(carRepository);
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public CarRepository carRepository() {
        return new CarMemoryRepository();
    }
}
