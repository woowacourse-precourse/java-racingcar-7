package racingcar.model;

public class Position {

    private static final int MOVE_DISTANCE = 1;
    private static final String NOTATION = "-";

    private int value;

    public Position(int value) {
        this.value = value;
    }

    public void moveForward() {
        value += MOVE_DISTANCE;
    }

    public boolean isEqualTo(int value) {
        return this.value == value;
    }

    public String getNotations() {
        return NOTATION.repeat(value);
    }

    public int getValue() {
        return value;
    }

}
