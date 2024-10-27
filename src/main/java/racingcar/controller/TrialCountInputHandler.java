package racingcar.controller;

import racingcar.validator.TrialCountValidator;
import racingcar.view.InputView;

public class TrialCountInputHandler {
    public int getTrialCount() {
        int trialCount = InputView.inputTrialCount();
        TrialCountValidator.validateTrialCount(trialCount);
        return trialCount;
    }
}
