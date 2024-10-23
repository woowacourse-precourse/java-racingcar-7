package racingcar;

import racingcar.controller.CarController;
import racingcar.entity.Input;
import racingcar.entity.TryCount;
import racingcar.service.CarService;
import racingcar.service.impl.CarServiceImpl;

public class Application {
    public static void main(String[] args) {
        CarService carService = new CarServiceImpl();
        CarController carController = new CarController(carService);

        Input input = carController.toInput();
        TryCount tryCount = carController.toTryCount();

        carController.process(input, tryCount);
    }
}
