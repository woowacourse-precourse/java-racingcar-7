package model;

import util.randomnumber.RandomNumberHandler;

public class CarPosition {
    private static final int INITIAL_POSITION = 0;

    private int position;
    private final RandomNumberHandler randomNumberHandler;

    public CarPosition(RandomNumberHandler movementHandler) {
        this.position = INITIAL_POSITION;
        this.randomNumberHandler = movementHandler;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        if (randomNumberHandler.canMove()) {
            position++;
        }
    }
}