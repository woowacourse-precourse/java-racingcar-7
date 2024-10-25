package racingcar.model;

public class Car {

    private static final int MOVING_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public Car(String name) {
        this(name, 0);
    }

    public void attemptMove(int movementFactor) {
        if (movementFactor >= MOVING_THRESHOLD) {
            position++;
        }
    }

}
