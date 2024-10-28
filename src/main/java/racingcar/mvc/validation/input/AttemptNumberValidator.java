package racingcar.mvc.validation.input;

public class AttemptNumberValidator {
    public static void isValid(String input) {
        isEmpty(input);

        isPositiveNumber(input);
    }

    private static void isEmpty(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException("입력하지 않았습니다.");
        }
    }

    private static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private static void isPositiveNumber(String input) {
        try {
            int number = Integer.parseInt(input);

            isPositive(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값은 숫자가 아닙니다.");
        }
    }

    private static void isPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("입력한 값은 양의 정수가 아닙니다.");
        }
    }
}
