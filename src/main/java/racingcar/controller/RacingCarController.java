package racingcar.controller;

import java.util.List;
import racingcar.domain.SeparateCarNames;
import racingcar.view.InputView;

public class RacingCarController {

    public RacingCarController() {
    }

    public void run() {
        String inputCarNames = InputView.enterCarNames();
        int inputNumberOfAttempts = InputView.enterNumberOfAttempts();

        List<String> carNames = SeparateCarNames.separateCarNames(inputCarNames);
    }
}
