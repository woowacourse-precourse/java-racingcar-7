package racingcar.model;

public class RacingCar {

    private static final int MOVING_THRESHOLD = 4;

    private final String name;
    private int position;

    public RacingCar(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public RacingCar(String name) {
        this(name, 0);
    }

    public void attemptMove(int movementFactor) {
        if (movementFactor >= MOVING_THRESHOLD) {
            position++;
        }
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }

    public int getPosition() {
        return position;
    }

}
