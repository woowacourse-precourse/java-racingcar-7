package racingcar.model;

public class Position {

    private static final int DEFAULT_POSITION = 0;
    private static final int MOVEMENT_DISTANCE = 1;

    private int value;

    private Position(int value) {
        this.value = value;
    }

    public static Position defaultValue() {
        return new Position(DEFAULT_POSITION);
    }

    public void moveForward() {
        value += MOVEMENT_DISTANCE;
    }

    public int compareTo(Position position) {
        return Integer.compare(this.value, position.value);
    }

    public int value() {
        return value;
    }
}