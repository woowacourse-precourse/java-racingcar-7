package racingcar;

import racingcar.controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        RacingGameFactory racingGameFactory = new RacingGameFactory();
        RacingGameController controller = racingGameFactory.initializeController();
        controller.startGame();
    }
}
