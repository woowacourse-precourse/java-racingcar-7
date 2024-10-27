package racingcar.domain;

import racingcar.util.RandomNumberGenerator;

import java.util.Objects;

public class CarPosition {

    public static final int START_POSITION = 0;
    public static final int MINIMUM_NUMBER = 4;

    private int position;

    public CarPosition() {
        this.position = START_POSITION;
    }

    public void increasePositionOnCondition() {
        if (RandomNumberGenerator.pickNumberInRange() >= MINIMUM_NUMBER) {
            position++;
        }
    }

    public boolean isGreaterThan(CarPosition other) {
        return this.position > other.position;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(position);
    }
}
