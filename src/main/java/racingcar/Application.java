package racingcar;

import racingcar.controller.racingGameController;

public class Application {
    public static void main(String[] args) {
        racingGameController racingGameController = new racingGameController();
        racingGameController.gameStart();
    }
}
