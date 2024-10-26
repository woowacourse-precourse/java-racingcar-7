package racingcar.factory;

import racingcar.model.MoveNumber;

public class NumberFactory {
    public static MoveNumber createMoveNumber(String moveNumberInput) {
        int moveNumber = transferMoveNumberToInt(moveNumberInput);
        return new MoveNumber(moveNumber);
    }

    private static int transferMoveNumberToInt(String moveNumberString) {
        try {
            return Integer.parseInt(moveNumberString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 된 이동 횟수를 입력해주세요.");
        }
    }
}
