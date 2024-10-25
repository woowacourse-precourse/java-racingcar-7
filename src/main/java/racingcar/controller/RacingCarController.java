package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {
    private final OutputView outputView;
    private final InputView inputView;

    public RacingCarController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.askForCarNames();
        List<String> carNames = inputView.askForCarNames();
        outputView.askForTryCount();
        int rounds = inputView.askForNumberOfRounds();
    }
}
