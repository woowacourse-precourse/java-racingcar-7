package racingcar.controller;

import java.util.List;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        List<String> carNames = getCarNames();
        int tryCount = getTryCount();
    }

    public List<String> getCarNames() {
        outputView.printCarNameInputMessage();
        return InputParser.parseCarNames(inputView.getInput());
    }

    public int getTryCount() {
        outputView.printTryCountInputMessage();
        return InputParser.parseTryCount(inputView.getInput());
    }
}
