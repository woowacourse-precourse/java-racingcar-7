package racingcar.controller;

import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;

    public GameController() {
        this.outputView = new OutputView();
    }

    public void startGame() {
        outputView.startMessage();
    }
}
