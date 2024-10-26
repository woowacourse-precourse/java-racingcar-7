package racingcar.service;

public class CarMoveManager {
    private static final int MOVE_THRESHOLD = 4;

    public boolean canMove(int number) {
        return number >= MOVE_THRESHOLD;
    }
}
