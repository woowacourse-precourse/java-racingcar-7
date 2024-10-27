package racingcar.app.server.model.race;

import static racingcar.app.server.error.ErrorMessage.LAP_COUNT_SHOULD_NOT_BE_MINUS;

import java.util.Objects;
import racingcar.app.server.exception.ShouldNotBeMinusException;

public class Lap {

    public static Lap ZERO = Lap.from(0L);
    public static Lap ONE = Lap.from(1);


    private final long value;

    private Lap(final long value) {
        this.value = value;
    }

    public static Lap from(final long source) {
        validateIsMinus(source);
        return new Lap(source);
    }

    public boolean hasRemaining() {
        return this.value > 0;
    }

    public boolean isZero() {
        return this.value == 0;
    }

    private boolean isLowerThanZero() {
        return this.value < 0;
    }

    public Lap minus(final Lap source) {
        if (source.isLowerThanZero()) {
            throw new ShouldNotBeMinusException(LAP_COUNT_SHOULD_NOT_BE_MINUS);
        }
        return Lap.from(this.value - source.value);
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Lap oLap = (Lap) obj;
        return this.value == oLap.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void validateIsMinus(long source) {
        if (source < 0) {
            throw new ShouldNotBeMinusException(LAP_COUNT_SHOULD_NOT_BE_MINUS);
        }
    }
}
