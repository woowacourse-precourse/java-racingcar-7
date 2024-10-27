package racingcar.domain;

public class TrialCount {

    private static final int MIN_TRIAL_COUNT = 0;
    private static final int DECREASE_AMOUT = 1;

    private int trialCount;

    public TrialCount(int value) {
        validateNotNegative(value);
        this.trialCount = value;
    }

    public boolean isCoinLeft() {
        return trialCount > 0;
    }

    public void decrease() {
        trialCount -= DECREASE_AMOUT;
    }

    private void validateNotNegative(int left) {
        if (left < MIN_TRIAL_COUNT) {
            throw new IllegalArgumentException("시도횟수는 음수이면 안됩니다");
        }
    }
}
