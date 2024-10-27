package racingcar.app.server.model.car;

import java.util.Objects;

public class Speed {

    private static final int MIN_SPEED_POLICY = 4;
    public static final Speed MIN_SPEED = minSpeed();

    private final long value;

    private Speed(final long value) {
        this.value = value;
    }

    public static Speed from(final long value) {
        return new Speed(value);
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
