package racingcar.controller;

import java.util.List;
import racingcar.utils.Utils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final OutputView outputView;
    private final InputView inputView;

    public RaceController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void raceRun() {
        outputView.printCarNameInputPrompt();
        String input = inputView.inputCarNames();
        List<String> carNameList = Utils.splitNames(input);
        outputView.printInputAttempsPrompt();
    }
}
