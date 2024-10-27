package racingcar.domain;

import static racingcar.exception.ExceptionMessage.TRY_COUNT_OUT_OF_RANGE;

public class TrialCount {

    public static final int START_TRY_COUNT = 1;
    public static final int END_TRY_COUNT = 10;

    private int count;

    public TrialCount(int count) {
        validateRange(count);
        this.count = count;
    }

    private void validateRange(int count) {
        if (count < START_TRY_COUNT || count > END_TRY_COUNT) {
            throw new IllegalArgumentException(
                    TRY_COUNT_OUT_OF_RANGE.formatMessage(START_TRY_COUNT, END_TRY_COUNT)
            );
        }
    }

    public boolean isProgress() {
        return count >= START_TRY_COUNT;
    }

    public void minusCount() {
        count--;
    }
}
