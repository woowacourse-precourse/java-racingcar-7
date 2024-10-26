package racingcar.service;

import racingcar.constant.InputType;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingService {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public String getInputCarName() {
        return requestInputString(InputType.CAR_NAME);
    }

    public String getInputTotalRound() {
        return requestInputString(InputType.TOTAL_ROUND);
    }

    private String requestInputString(InputType inputType) {
        outputView.printAskInput(inputType);
        return inputView.read();
    }
}