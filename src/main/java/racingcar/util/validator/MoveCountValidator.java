package racingcar.util.validator;

import static racingcar.util.message.ErrorMessages.ERROR_NEGATIVE_MOVE_COUNT;

public class MoveCountValidator {
    public void validateMoveCount(int moveCount) {
        validateMoveCountNegative(moveCount);
    }
    private void validateMoveCountNegative(int moveCount) {
        if (moveCount < 0) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_MOVE_COUNT);
        }
    }
}
