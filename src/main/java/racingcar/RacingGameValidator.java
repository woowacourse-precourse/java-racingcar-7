package racingcar;

public class RacingGameValidator extends BaseValidator {

    public static void validateMoveCount(final int moveCount) {
        validatePositiveNumber(moveCount, "이동 횟수는 1 이상이어야 합니다.");
    }
}
