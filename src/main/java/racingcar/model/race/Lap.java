package racingcar.model.race;

import java.util.Objects;
import racingcar.model.race.exception.ShouldNotBeMinusException;

public class Lap {
    public static Lap ZERO = Lap.from(0L);

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

    public Lap minus(final long source) {
        if (source < 0) {
            throw new ShouldNotBeMinusException();
        }

        long subtracted = this.value - source;
        if (subtracted < 0) {
            throw new ShouldNotBeMinusException();
        }
        return new Lap(subtracted);
    }

    public static void validateIsMinus(long source) {
        if (source < 0) {
            throw new ShouldNotBeMinusException();
        }
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
}
