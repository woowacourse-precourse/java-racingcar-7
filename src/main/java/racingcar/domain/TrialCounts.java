package racingcar.domain;

import racingcar.domain.validator.TrialCountsValidator;

public class TrialCounts {
    private final int trialCounts;

    public TrialCounts(String trialCounts, TrialCountsValidator trialCountsValidator) {
        this.trialCounts = trialCountsValidator.validate(trialCounts);
    }

    public int getTrialCounts() {
        return trialCounts;
    }
}
