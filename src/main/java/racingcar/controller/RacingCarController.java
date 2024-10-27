package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        outputView.printCarNameInputMessage();
        String carNames = inputView.getInput();
        outputView.printTryCountInputMessage();
        int tryCount = Integer.parseInt(inputView.getInput());
    }
}
