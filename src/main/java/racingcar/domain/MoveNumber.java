package racingcar.domain;

import static racingcar.validation.Exceptions.INSUFFICIENT_MOVE_NUMBER;

public class MoveNumber {
    private static final int MIN_MOVE_NUMBER = 1;
    private final int moveNumber;

    public MoveNumber(int moveNumber) {
        validatePositiveMoveNumber(moveNumber);
        this.moveNumber = moveNumber;
    }

    private void validatePositiveMoveNumber(int moveNumber) {
        if (moveNumber < MIN_MOVE_NUMBER) {
            throw new IllegalArgumentException(INSUFFICIENT_MOVE_NUMBER.getMsg());
        }
    }

    public int getMoveNumber() {
        return moveNumber;
    }

}
