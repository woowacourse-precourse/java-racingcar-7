package racingcar.car;

import racingcar.exception.InvalidAttemptException;

public class Attempt {

    private final long value;

    public Attempt(final long value) {
        validate(value);
        this.value = value;
    }

    private void validate(final long attempt) {
        if (attempt < 0) {
            throw new InvalidAttemptException("시도 횟수는 양수여야 합니다.");
        }
    }

    public long getValue() {
        return value;
    }
}
