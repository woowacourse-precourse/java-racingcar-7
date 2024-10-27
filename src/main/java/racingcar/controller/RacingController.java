package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        List<String> carNames = getCarNames();
    }

    private List<String> getCarNames() {
        return inputView.readCarNames();
    }
}
