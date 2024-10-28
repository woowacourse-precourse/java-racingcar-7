package racingcar.util;

public class InputValidator {
    private static final int MAX_NAME_LENGTH = 5;

    public static void validateName(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

    public static void validateAttempts(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자를 입력해주세요.");
        }
    }
}