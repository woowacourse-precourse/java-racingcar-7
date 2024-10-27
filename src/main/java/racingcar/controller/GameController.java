package racingcar.controller;

import racingcar.view.GameView;

public final class GameController {
    private final GameView gameView;

    public GameController(GameView gameView) {
        this.gameView = gameView;
    }

    public void run() {
        String carNamesInput = gameView.getCarNamesInput();
    }
}
