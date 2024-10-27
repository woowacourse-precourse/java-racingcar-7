package racingcar;

import racingcar.car.controller.CarController;
import racingcar.car.infrastructure.CarRandomHolder;
import racingcar.car.service.CarService;
import racingcar.car.service.port.RandomHolder;

public class AppConfig {

    public CarController carController() {
        return new CarController(carService());
    }

    private CarService carService() {
        return new CarService(randomHolder());
    }

    private RandomHolder randomHolder() {
        return new CarRandomHolder();
    }
}
