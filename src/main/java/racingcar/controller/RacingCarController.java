package racingcar.controller;

import java.util.List;
import racingcar.view.InputView;

public class RacingCarController {
    private final InputView inputView = new InputView();

    public void run() {
        List<String> carNamesList;
        String carNames;
        int tryCount;

        inputView.displayCarNamesPrompt();
        carNames = inputView.inputCarNames();
        inputView.displayTryCountPrompt();
        tryCount = inputView.inputTryCount();
        carNamesList = inputView.splitCarNamesToList(carNames);
    }
}
