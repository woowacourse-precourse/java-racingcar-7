package racingcar;

public class InputValidator {

    private static final int MAX_NAME_LENGTH = 5;

    public static void validateCarName(String name) {
        validateNameIsNull(name);
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("차의 이름은 5글자 이하여야 합니다.");
        }
    }

    public static void validateNumeric(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException("시도 횟수는 최소 한 번 입니다.");
        }
    }

    private static void validateNameIsNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("차의 이름이 null 이면 안됩니다.");
        }
        validateNameHasSpaces(name);
    }

    private static void validateNameHasSpaces(String name) {
        if (name.contains(" ")) {
            throw new IllegalArgumentException("차의 이름에 공백을 포함하면 안됩니다.");
        }
    }

}
