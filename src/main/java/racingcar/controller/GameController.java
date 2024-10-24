package racingcar.controller;

import racingcar.view.GameView;

public class GameController {
    GameView gameView = new GameView();

    public void gameStart() {
        gameView.getInputCarNames();
        gameView.getInputTryCount();
    }




}
