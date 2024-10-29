package racingcar.model.domain.vo;

import java.util.Objects;

public class Distance {
    private final int value;

    public Distance(int value) {
        this.value = value;
        validateValue();
    }

    private void validateValue() {
        if (this.value < 0) {
            throw new IllegalArgumentException("거리는 0 이상이여야 합니다.");
        }
    }

    public Distance add() {
        return new Distance(this.value + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Distance distance = (Distance) o;

        return value == distance.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int getValue() {
        return value;
    }
}
