package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {

    private final OutputView outputView;
    private final InputView inputView;

    public GameController() {
        this.outputView = new OutputView();
        this.inputView = new InputView();
    }

    public void startGame() {
        outputView.startMessage();
        String carNames = inputView.userInput();
    }
}
