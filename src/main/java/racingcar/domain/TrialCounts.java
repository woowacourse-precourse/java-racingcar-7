package racingcar.domain;

public class TrialCounts {
    private final int trialCounts;

    public TrialCounts(String trialCounts, TrialCountsValidator trialCountsValidator) {
        trialCountsValidator.validate(trialCounts);
        this.trialCounts = Integer.parseInt(trialCounts);
    }

    public int getTrialCounts() {
        return trialCounts;
    }
}
