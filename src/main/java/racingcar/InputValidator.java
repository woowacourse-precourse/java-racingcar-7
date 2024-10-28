package racingcar;

public class InputValidator {
    public static void validateCarNames(String[] names) {
        for (String name : names) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 잘못입력했습니다.");
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 미만이어야합니다.");
            }
        }
    }

    public static void validateMoveCount(int moveCount) {
        if (moveCount <= 0) {
            throw new IllegalArgumentException("이동숫자를 1이상 입력해야합니다.");
        }
    }
}
