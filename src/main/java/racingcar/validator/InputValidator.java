package racingcar.validator;

public class InputValidator {
    public static void validateMaxLength5(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("이름은 다섯 글자를 초과할 수 없습니다.");
        }
    }

    public static int parseIntWithValidation(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값이 아닙니다 : " + input);
        }
    }
}