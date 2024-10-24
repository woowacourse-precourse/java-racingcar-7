package racingcar.controller;

import racingcar.utils.StringSplitter;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class RacingController {

    private final InputView inputView;
    private final OutputView outputView;
    private final StringSplitter stringSplitter;

    public RacingController(InputView inputView, OutputView outputView, StringSplitter stringSplitter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stringSplitter = stringSplitter;
    }

    public void run() {
        outputView.askCarName();
        String carNames = inputView.askCarName();
        List<String> carList = stringSplitter.split(carNames);
    }
}
