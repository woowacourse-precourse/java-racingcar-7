package racingcar.domain.car.value;

import java.util.Objects;

public final class Distance {

    private final int value;

    public Distance() {
        this(0);
    }

    public Distance(int value) {
        this.value = value;
    }

    public Distance forward() {
        return new Distance(value + 1);
    }

    public int getValue() {
        return value;
    }

    public String getTextValue() {
        return "-".repeat(Math.max(0, value));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
