package racingcar.model.race;

import static java.util.Objects.isNull;

import java.math.BigInteger;
import java.util.Objects;
import racingcar.common.constant.SystemConstant;
import racingcar.common.exception.ShouldNotBeNullException;

public class Lap {
    public static Lap ZERO = Lap.of(BigInteger.valueOf(SystemConstant.ZERO));

    private BigInteger value;

    private Lap(final BigInteger value) {
        this.value = value;
    }

    public static Lap of(final BigInteger value) {
        validateIsNull(value);
        return new Lap(value);
    }

    public boolean hasRemaining() {
        return !this.equals(ZERO);
    }

    public boolean isZero() {
        return this.equals(ZERO);
    }

    public void minus(final String value) {
        this.value = this.value.subtract(new BigInteger(value));
    }

    private static void validateIsNull(final BigInteger value) {
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
