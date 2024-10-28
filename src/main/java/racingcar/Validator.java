package racingcar;

public class Validator {
    public static void validateCarName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }
        if (!name.matches("^[a-zA-Z]+$")) {
            throw new IllegalArgumentException("자동차 이름은 알파벳 문자만 포함할 수 있습니다.");
        }
    }

    public static void validateUserInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
        }
    }
}