package racingcar.model.game.attempt;

import java.util.Objects;
import racingcar.exception.InvalidAttemptException;

public class Attempt {

    private final long value;

    public Attempt(final long value) {
        validate(value);
        this.value = value;
    }

    private void validate(final long attempt) {
        if (attempt < 0) {
            throw new InvalidAttemptException("시도 횟수는 0 또는 양수여야 합니다.");
        }
    }

    public long value() {
        return value;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attempt attempt = (Attempt) o;
        return value == attempt.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
