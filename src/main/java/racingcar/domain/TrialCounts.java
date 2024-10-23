package racingcar.domain;

public class TrialCounts {
    private final int trialCounts;

    public TrialCounts(String trialCounts) {
        validateProcess(trialCounts);
        this.trialCounts = Integer.parseInt(trialCounts);
    }

    private void validateProcess(String trialCounts) {
        int counts = validateIsNumber(trialCounts);
        validateIsZero(counts);
    }

    private int validateIsNumber(String trialCounts) {
        int tempCounts;
        try {
            tempCounts = Integer.parseInt(trialCounts);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return tempCounts;
    }

    private void validateIsZero(int counts) {
        if(counts <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
