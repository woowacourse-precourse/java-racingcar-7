package racingcar.global;

import java.util.Map;
import racingcar.car.controller.CarController;

public class GameApplication {
    public void start() {
        CarController carController = new CarController();
        Map<String, String> race = carController.createCars();
    }
}
