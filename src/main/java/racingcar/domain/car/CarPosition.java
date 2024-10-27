package racingcar.domain.car;

public class CarPosition {
    private int position;

    public int addPosition() {
        return ++position;
    }

    public boolean isGreaterThanOrEqualTo(Integer otherCarCurrentPosition) {
        return this.position >= otherCarCurrentPosition;
    }

    public int getPosition() {
        return position;
    }

}
