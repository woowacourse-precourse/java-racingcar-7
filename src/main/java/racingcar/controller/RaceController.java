package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TrialCountsValidator trialCountsValidator = new TrialCountsValidator();
    private final OutputView outputView;

    public RaceController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = initializeCars();
        TrialCounts trialCounts = initializeTrialCounts();

        InputView.closeConsole();

        Race race = new Race(cars, trialCounts);
        Winner winner = runRace(cars, race);

        endRace(winner);
    }

    private Cars initializeCars() {
        String carNames = InputView.inputCarNames();
        return new Cars(carNames, carNameValidator);
    }

    private TrialCounts initializeTrialCounts() {
        String counts = InputView.inputTrialCounts();
        return new TrialCounts(counts, trialCountsValidator);
    }

    private Winner runRace(Cars cars, Race race) {
        outputView.executionResultMessage();
        while (race.isRaceOngoing()) {
            race.raceOneStep();
            outputView.currentStatusMessage(cars);
        }
        return new Winner(cars);
    }

    private void endRace(Winner winner) {
        outputView.finalWinnerMessage(winner.getWinners());
    }
}

