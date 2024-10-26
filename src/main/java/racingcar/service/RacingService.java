package racingcar.service;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingService {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingService(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
}