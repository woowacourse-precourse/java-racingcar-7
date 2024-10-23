package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final CarNameValidator carNameValidator;
    private final TrialCountsValidator trialCountsValidator;
    private final OutputView outputView;

    public RaceController(CarNameValidator carNameValidator, TrialCountsValidator trialCountsValidator, OutputView outputView) {
        this.carNameValidator = carNameValidator;
        this.trialCountsValidator = trialCountsValidator;
        this.outputView = outputView;
    }

    public void start() {
        Cars cars = initializeCars();
        TrialCounts trialCounts = initializeTrialCounts();
        InputView.closeConsole();
        runRace(cars, trialCounts);
    }

    private Cars initializeCars() {
        String carNames = InputView.inputCarNames();
        return new Cars(carNames, carNameValidator);
    }

    private TrialCounts initializeTrialCounts() {
        String counts = InputView.inputTrialCounts();
        return new TrialCounts(counts, trialCountsValidator);
    }

    private void runRace(Cars cars, TrialCounts trialCounts) {
        Race race = new Race(cars, trialCounts);
        outputView.executionResultMessage();
        while (race.isRaceOngoing()) {
            race.raceOneStep();
            outputView.currentStatusMessage(cars);
        }
        outputView.finalWinnerMessage(race.getWinners());
    }
}

