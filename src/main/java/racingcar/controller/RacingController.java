package racingcar.controller;

import java.util.List;
import racingcar.service.NameSplitter;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;
    private final NameSplitter nameSplitter;

    public RacingController(
            InputView inputView,
            NameSplitter nameSplitter
    ) {
        this.inputView = inputView;
        this.nameSplitter = nameSplitter;
    }

    public void run() {
        String userInput = inputView.getCarNames();
        List<String> splitNames = nameSplitter.splitNames(userInput);

    }
}
