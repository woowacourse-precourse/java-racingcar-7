package racingcar.validation;

import static racingcar.validation.Exceptions.INSUFFICIENT_MOVE_NUMBER;

public class MoveNumberValidator implements Validator<Integer> {
    private static final int MIN_MOVE_NUMBER = 1;

    @Override
    public void validate(Integer moveNumber) {
        validatePositiveMoveNumber(moveNumber);
    }

    private void validatePositiveMoveNumber(int moveNumber) {
        if (moveNumber < MIN_MOVE_NUMBER) {
            throw new IllegalArgumentException(INSUFFICIENT_MOVE_NUMBER.getMsg());
        }
    }
}
