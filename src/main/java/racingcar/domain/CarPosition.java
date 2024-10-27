package racingcar.domain;

public class CarPosition {

    private final static int INITIAL_POS = 0;
    private final static int MOVE_UNIT = 1;

    private int carPosition;

    public CarPosition() {
        this.carPosition = INITIAL_POS;
    }

    public void moveForward() {
        this.carPosition += MOVE_UNIT;
    }

    public int getCarPosition() {
        return carPosition;
    }
}
