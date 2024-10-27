package racingcar;

import racingcar.controller.CarRacingGameController;

public class Application {
    public static void main(String[] args) {
        CarRacingGameController gameController = new CarRacingGameController();
        gameController.run();
    }
}
