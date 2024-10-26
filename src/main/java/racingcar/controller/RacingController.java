package racingcar.controller;

import racingcar.message.ExceptionCode;
import racingcar.view.InputView;

public class RacingController {

    private final InputView inputView;

    public RacingController(InputView inputView) {
        this.inputView = inputView;
    }

    public void run() {
        String inputCarNameList = inputView.inputCarNames();

        String[] carNameList = inputCarNameList.split(",");

        int inputTurns = 0;
        try {
            inputTurns = Integer.parseInt(inputView.inputTurnCount());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_TURN.getDescription());
        }
    }
}
