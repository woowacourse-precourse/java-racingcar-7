package racingcar;

import racingcar.controller.ConsoleRacingController;
import racingcar.controller.RacingController;
import racingcar.repository.CarMemoryRepository;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.service.CarServiceImpl;
import racingcar.view.ConsoleRacingView;
import racingcar.view.RacingView;

public class AppConfig {
    
    public RacingController racingController() {
        return new ConsoleRacingController(racingView(), carService());
    }

    public CarService carService() {
        return new CarServiceImpl(carRepository());
    }

    public RacingView racingView() {
        return new ConsoleRacingView();
    }

    public CarRepository carRepository() {
        return new CarMemoryRepository();
    }
}
