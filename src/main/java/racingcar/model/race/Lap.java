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

    public static Lap from(final String source) {
        validateIsNull(source);
        validateIsNegative(source);
        BigInteger value = new BigInteger(source);
        return new Lap(value);
    }

    public boolean hasRemaining() {
        return !this.equals(ZERO);
    }

    public boolean isZero() {
        return this.equals(ZERO);
    }

    public void minus(final String source) {
        BigInteger subtrahend = new BigInteger(source);
        if (isNegative(subtrahend)) {
            throw new ShouldNotBeMinusException();
        }

        BigInteger subtracted = this.value.subtract(subtrahend);
        if (isNegative(subtracted)) {
            throw new ShouldNotBeMinusException();
        }

        this.value = subtracted;
    }

    public boolean isNegative(BigInteger source) {
        return source.compareTo(BigInteger.ZERO) < 0;
    }

    private static void validateIsNull(final String source) {
        if (isNull(source)) {
            throw new ShouldNotBeNullException();
        }
    }

    public static void validateIsNegative(String source) {
        BigInteger target = new BigInteger(source);
        boolean isNegative = target.compareTo(BigInteger.ZERO) < 0;
        if (isNegative) {
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
        return this.value.equals(oLap.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
