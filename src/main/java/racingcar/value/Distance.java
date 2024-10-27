package racingcar.value;

import java.util.Objects;

public class Distance {

    private Long value;

    private Distance(Long value) {
        this.value = value;
    }

    public static Distance init() {
        return new Distance(0L);
    }

    public void increase() {
        this.value++;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Distance distance = (Distance) o;
        return Objects.equals(value, distance.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}