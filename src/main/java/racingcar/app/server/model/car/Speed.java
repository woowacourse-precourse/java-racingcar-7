package racingcar.app.server.model.car;

import static racingcar.app.server.error.ErrorMessage.SPEED_SHOULD_NOT_BE_MINUS;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Objects;
import racingcar.app.server.exception.ShouldNotBeMinusException;

public class Speed {

    private static final int MIN_SPEED_POLICY = 4;
    private static final int MIN_RANDOM_IDX = 0;
    private static final int MAX_RANDOM_IDX = 9;

    public static final Speed MIN_SPEED = minSpeed();

    private final long value;

    private Speed(final long value) {
        this.value = value;
    }

    public static Speed from(final long value) {
        validateIsMinus(value);
        return new Speed(value);
    }

    public static Speed generateRandomSpeed() {
        return Speed.from(Randoms.pickNumberInRange(MIN_RANDOM_IDX, MAX_RANDOM_IDX));
    }

    private static Speed minSpeed() {
        return Speed.from(MIN_SPEED_POLICY);
    }

    public boolean foeThan(Speed speed) {
        return this.value >= speed.value;
    }

    public boolean slowerThan(Speed speed) {
        return this.value < speed.value;
    }

    private static void validateIsMinus(long value) {
        if (value < 0) {
            throw new ShouldNotBeMinusException(SPEED_SHOULD_NOT_BE_MINUS);
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Speed oSpeed = (Speed) obj;
        return oSpeed.value == this.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
