package racingcar;

import racingcar.controller.CarController;

public class Application {
    private static CarController carController = new CarController();

    public static void main(String[] args) {
        carController.startGame();
    }
}
