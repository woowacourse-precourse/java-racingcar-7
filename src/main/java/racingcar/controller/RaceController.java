package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void playGame() {
        final String carNames = InputView.inputCarNames();
        final int tryCount = InputView.getTryCount();

        String winners = "";
        OutputView.printWinners(winners);
    }
}
