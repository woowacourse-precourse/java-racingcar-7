package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;

public class RacingController {
    private final InputView inputView;
    private final StringSplitter stringSplitter;

    public RacingController(
            InputView inputView,
            StringSplitter stringSplitter
    ) {
        this.inputView = inputView;
        this.stringSplitter = stringSplitter;
    }

    public void run() {
        String userInput = inputView.getCarNames();
        List<String> splitNames = stringSplitter.split(userInput);

    }
}
