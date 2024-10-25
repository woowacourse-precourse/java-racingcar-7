package racingcar.model.race;

import static java.util.Objects.isNull;
import static racingcar.common.constant.SystemConstant.STR_ZERO;

import java.math.BigInteger;
import java.util.Objects;
import racingcar.common.exception.ShouldNotBeNullException;
import racingcar.model.race.exception.ShouldNotBeMinusException;

public class Lap {
    public static Lap ZERO = Lap.from(STR_ZERO);

    private BigInteger value;

    private Lap(final BigInteger value) {
        this.value = value;
    }

    public static Lap from(final String value) {
        validateIsNull(value);
        return new Lap(new BigInteger(value));
    }

    public boolean hasRemaining() {
        return !this.equals(ZERO);
    }

    public boolean isZero() {
        return this.equals(ZERO);
    }

    public void minus(final String value) {
        BigInteger subtrahend = new BigInteger(value);
        if (isLowerThanZero()) {
            throw new ShouldNotBeMinusException();
        }
        this.value = this.value.subtract(subtrahend);
    }

    public boolean isLowerThanZero() {
        return this.value.compareTo(BigInteger.ZERO) < 0;
    }

    private static void validateIsNull(final String value) {
        if (isNull(value)) {
            throw new ShouldNotBeNullException();
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
        return this.value.equals(oLap.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
