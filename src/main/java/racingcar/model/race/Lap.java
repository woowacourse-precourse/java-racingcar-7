package racingcar.model.race;

import static java.util.Objects.isNull;
import static racingcar.common.constant.SystemConstant.STR_ZERO;

import java.math.BigInteger;
import java.util.Objects;
import racingcar.common.constant.SystemConstant;
import racingcar.common.exception.ShouldNotBeNullException;

public class Lap {
    public static Lap ZERO = Lap.initiate(STR_ZERO);

    private final BigInteger value;

    private Lap(final BigInteger value) {
        this.value = value;
    }

    public static Lap initiate(final String value) {
        if (isNull(value)) {
            throw new ShouldNotBeNullException();
        }
        return new Lap(new BigInteger(value));
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
