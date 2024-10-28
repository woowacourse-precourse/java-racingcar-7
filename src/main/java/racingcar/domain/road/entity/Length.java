package racingcar.domain.road.entity;

public enum Length {

    FORWARD(1), INITIALIZE(0);

    private final int value;

    Length(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
