package racingcar.controller;

import racingcar.domain.CarNameValidator;
import racingcar.domain.Cars;
import racingcar.domain.TrialCounts;
import racingcar.domain.TrialCountsValidator;
import racingcar.view.InputView;

public class RaceController {
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final TrialCountsValidator trialCountsValidator = new TrialCountsValidator();

    public void start() {
        getInput();
    }

    private void getInput() {
        String carNames = InputView.inputCarNames();
        Cars cars = new Cars(carNames, carNameValidator);

        String counts = InputView.inputTrialCounts();
        TrialCounts trialCounts = new TrialCounts(counts, trialCountsValidator);
    }
}
