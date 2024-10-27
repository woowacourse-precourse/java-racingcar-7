package racingcar.utils;

public class InputValidator {

    private static final String NAME_PATTERN = "^[a-zA-Z]+(,[a-zA-Z]+)*$";

    public static void nameValidator(String input) {
        if (!input.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException("자동차 이름 입력이 잘못되었습니다.");
        }
    }

    public static void numberValidator(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수 입력이 잘못되었습니다.");
        }

        if (number <= 0) throw new IllegalArgumentException("횟수는 0보다 큰 양수여야 합니다.");
    }
}
