package racingcar.controller;

import racingcar.view.input.InputView;
import racingcar.view.output.OutputView;

import static racingcar.constants.OutputMessages.ASK_CAR_NAMES;
import static racingcar.constants.OutputMessages.ASK_TRY_COUNT;

public class RacingController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        outputView.printMessage(ASK_CAR_NAMES);
        String carNames = inputView.userInput();

        outputView.printMessage(ASK_TRY_COUNT);
        int tryCount = Integer.parseInt(inputView.userInput());
    }
}
