package racingcar.model;

public class Car {
    private static final int MOVING_DISTANCE = 1;
    private static final int MOVING_MIN_VALUE = 4;

    private final Name name;
    private final Position position;

    public Car(String name) {
        this.name = new Name(name);
        this.position = new Position();
    }

    public String getName() {
        return this.name.toString();
    }

    public int getPosition() {
        return this.position.toInteger();
    }

    public void move(int value) {
        if (value >= MOVING_MIN_VALUE) {
            position.move(MOVING_DISTANCE);
        }
    }
}
