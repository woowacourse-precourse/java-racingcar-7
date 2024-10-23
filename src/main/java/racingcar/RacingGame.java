package racingcar;

import racingcar.controller.GameController;

public class RacingGame {

    private GameController gameController;

    public void run() {
        gameController = new GameController();
    }
}
