package racingcar.domain.car;

import java.util.Objects;

public class CarPosition {
    private final int position;

    public static CarPosition of(int position) {
        return new CarPosition(position);
    }

    private CarPosition(int position) {
        this.position = position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition carPosition = (CarPosition) o;
        return position == carPosition.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
