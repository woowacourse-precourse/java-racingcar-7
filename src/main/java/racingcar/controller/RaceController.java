package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void run() {
        Race race = setupRace();
    }

    private Race setupRace() {
        OutputView.renderFirstRun();
        return Race.setupRace(InputView.getCarNames());
    }

    private int getAttemptCount() {
        OutputView.renderAttemptCountInput();
        return InputView.getAttemptCount();
    }

}
