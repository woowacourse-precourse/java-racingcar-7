package racingcar;

import racingcar.controllers.CarController;

public class Application {
    public static void main(String[] args) {
        CarController carController = new CarController();
        carController.start();
    }
}
