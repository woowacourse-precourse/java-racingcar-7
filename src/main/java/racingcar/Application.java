package racingcar;

import racingcar.car.controller.CarController;

public class Application {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        CarController carController = appConfig.carController();
        carController.start();
    }
}
