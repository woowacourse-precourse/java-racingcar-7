package racingcar.domain;

import static racingcar.constant.ExceptionMessage.TRY_COUNT_MUST_BE_POSITIVE;

public class TryCount {

    private static final int MINIMUM_TRY_COUNT = 0;

    private Integer count;

    public void set(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MINIMUM_TRY_COUNT) {
            throw new IllegalArgumentException(TRY_COUNT_MUST_BE_POSITIVE.getMessage());
        }
    }

    public void playRound() {
        count--;
    }

    public boolean remain() {
        return count > MINIMUM_TRY_COUNT;
    }
}
