package racingcar.controller;

import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.domain.TrialCounts;
import racingcar.domain.Winner;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {

    public void start() {
        final Cars cars = initializeCars();
        final TrialCounts trialCounts = initializeTrialCounts();
        final Race race = new Race(cars, trialCounts);
        final Winner winner = runRace(cars, race);

        endRace(winner);
    }

    private Cars initializeCars() {
        String carNames = InputView.inputCarNames();
        final CarNameValidator carNameValidator = new CarNameValidator();
        return new Cars(carNames, carNameValidator);
    }

    private TrialCounts initializeTrialCounts() {
        String counts = InputView.inputTrialCounts();
        final TrialCountsValidator trialCountsValidator = new TrialCountsValidator();
        return new TrialCounts(counts, trialCountsValidator);
    }

    private Winner runRace(Cars cars, Race race) {
        OutputView.executionResultMessage();
        while (race.getRaceStatus()) {
            race.startRace();
            OutputView.currentStatusMessage(cars);
        }
        return new Winner(cars);
    }

    private void endRace(Winner winner) {
        OutputView.finalWinnerMessage(winner.getWinners());
    }
}

