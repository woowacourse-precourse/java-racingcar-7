package racingcar.model.game.attempt;

import java.util.Objects;
import racingcar.exception.InvalidAttemptException;

public class Attempt {

    private final long attempt;

    public Attempt(final long attempt) {
        validate(attempt);
        this.attempt = attempt;
    }

    private void validate(final long attempt) {
        if (attempt < 0) {
            throw new InvalidAttemptException("시도 횟수는 0 또는 양수여야 합니다.");
        }
    }

    public long attempt() {
        return attempt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Attempt other = (Attempt) o;
        return attempt == other.attempt;
    }

    @Override
    public int hashCode() {
        return Objects.hash(attempt);
    }
}
