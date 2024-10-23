package racingcar.controller;

import racingcar.domain.*;
import racingcar.domain.validator.CarNameValidator;
import racingcar.domain.validator.TrialCountsValidator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RaceController {
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TrialCountsValidator trialCountsValidator = new TrialCountsValidator();
    private final OutputView outputView = new OutputView();

    public void start() {
        String carNames = InputView.inputCarNames();
        Cars cars = new Cars(carNames, carNameValidator);

        String counts = InputView.inputTrialCounts();
        TrialCounts trialCounts = new TrialCounts(counts, trialCountsValidator);

        InputView.closeConsole();

        Race race = new Race(cars, trialCounts);

        outputView.executionResultMessage();
        while (race.isRaceOngoing()) {
            race.raceOneStep();
            outputView.currentStatusMessage(cars);
        }
        outputView.finalWinnerMessage(race.getWinners());
    }
}
