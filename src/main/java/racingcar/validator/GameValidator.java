package racingcar.validator;

public class GameValidator {
    public static void validateName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("유효한 자동차 이름을 입력해주세요");
        }
    }

    public static void validateMoveCount(int count) {
        if (count <= -1) {
            throw new IllegalArgumentException("유효한 횟수를 입력해주세요");
        }
    }

}
