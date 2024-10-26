package racingcar.enums;

public enum Move {
    MOVING_STANDARD(4),
    MIN_MOVING_RANGE(0),
    MAX_MOVING_RANGE(9);


    private final int movement;

    Move(int movement) {
        this.movement = movement;
    }

    public int getMovement() {
        return movement;
    }
}
