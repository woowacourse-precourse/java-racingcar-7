package racingcar.controller;

import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void run() {
        Race race = setupRace();
        racing(race, getAttemptCount());
        result(race);
    }

    private Race setupRace() {
        OutputView.renderFirstRun();
        return Race.setupRace(InputView.getCarNames());
    }

    private int getAttemptCount() {
        OutputView.renderAttemptCountInput();
        return InputView.getAttemptCount();
    }

    private void racing(Race race, int attemptCount) {
        OutputView.preRenderResult();
        for (int i = 0; i < attemptCount; i++) {
            race.doRace();
            OutputView.renderResult(race);
        }
    }

    private void result(Race race) {
        OutputView.renderWinners(race.getWinners());
    }

}
