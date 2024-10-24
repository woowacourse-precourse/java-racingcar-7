package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.askForCarNames();
        List<String> carNames = inputView.askForCarNames();
        outputView.askForTryCount();
        int tryCount = inputView.askForNumberOfRounds();
    }
}
