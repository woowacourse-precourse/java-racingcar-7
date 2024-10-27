package racingcar.controller;

import racingcar.domain.Race;
import racingcar.util.ParseStringUtil;
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
        return Race.setupRace(InputView.getInput());
    }

    private int getAttemptCount() {
        OutputView.renderAttemptCountInput();
        return ParseStringUtil.parseAttemptCount(InputView.getInput());
    }

    private void racing(final Race race, final int attemptCount) {
        OutputView.preRenderResult();
        for (int i = 0; i < attemptCount; i++) {
            race.doRace();
            OutputView.renderResult(race);
        }
    }

    private void result(final Race race) {
        OutputView.renderWinners(race.getWinners());
    }

}
