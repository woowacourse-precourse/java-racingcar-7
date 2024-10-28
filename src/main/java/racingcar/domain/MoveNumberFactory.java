package racingcar.domain;

import static racingcar.validation.Exceptions.MOVE_NUMBER_NOT_INTEGER;

import racingcar.validation.MoveNumberValidator;
import racingcar.validation.Validator;

public class MoveNumberFactory {
    private static final Validator<Integer> validator = new MoveNumberValidator();

    public static MoveNumber createMoveNumber(String moveNumberInput) {
        int moveNumber = transferMoveNumberToInt(moveNumberInput);
        validator.validate(moveNumber);
        return new MoveNumber(moveNumber);
    }

    private static int transferMoveNumberToInt(String moveNumberString) {
        try {
            return Integer.parseInt(moveNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(MOVE_NUMBER_NOT_INTEGER.getMsg());
        }
    }
}
