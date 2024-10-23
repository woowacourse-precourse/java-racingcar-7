package racingcar.controller;

import racingcar.util.Separator;
import racingcar.view.InputView;

public class RacingGameController {

    private final InputView inputView;
    private final Separator separator;

    public RacingGameController(InputView inputView, Separator separator) {
        this.inputView = inputView;
        this.separator = separator;
    }

    public void run() {
        gameSetting();
    }

    private void gameSetting() {
        String[] carNames = separator.splitWithComma(inputView.getCarNames());

        int attemptInput = inputView.getGameAttempt();

    }

}
