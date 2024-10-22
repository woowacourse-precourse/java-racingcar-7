package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.InputController;
import racingcar.repository.CarMemoryRepository;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.service.GameService;
import racingcar.service.GameServiceImpl;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class AppConfig {

    private final CarRepository carRepository = carRepository();

    public InputController inputController() {
        return new InputController(carService(carRepository), inputView());
    }

    public GameController gameController() {
        return new GameController(gameService(carRepository), outputView());
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
