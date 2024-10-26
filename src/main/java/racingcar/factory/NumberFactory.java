package racingcar.factory;

import static racingcar.validation.Exceptions.MOVE_NUMBER_NOT_INTEGER;

import racingcar.domain.MoveNumber;

public class NumberFactory {
    public static MoveNumber createMoveNumber(String moveNumberInput) {
        int moveNumber = transferMoveNumberToInt(moveNumberInput);
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
