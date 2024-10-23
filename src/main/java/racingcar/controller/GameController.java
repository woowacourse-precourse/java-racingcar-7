package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;

public class GameController {
    public void start() {
        OutputView.printInputNamesMessage();
        String carNames = InputView.readInput();

        OutputView.printInputRoundMessage();
        String round = InputView.readInput();
        int roundCount = Integer.parseInt(round);
    }
}
