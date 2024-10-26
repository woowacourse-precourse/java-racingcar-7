package racingcar.validator;

public class TryCountValidator {
    public static void validateTryCount(final String input) {
        validateOnlyDigits(input);
        validateNotOverflow(input);
        validatePositive(input);
    }

    private static void validateOnlyDigits(final String input) {
        if (!containsOnlyDigits(input)) {
            throw new IllegalArgumentException("[ERROR] 시도횟수는 숫자로만 입력되어야 합니다.");
        }
    }

    private static void validatePositive(final String input) {
        if (!isPositive(input)) {
            throw new IllegalArgumentException("[ERROR] 1이상의 숫자만 입력 가능합니다.");
        }
    }

    private static void validateNotOverflow(final String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] int 범위의 숫자로만 입력되어야 합니다.");
        }
    }

    private static boolean containsOnlyDigits(final String input) {
        return input.chars().allMatch(Character::isDigit);
    }

    private static boolean isPositive(final String input) {
        int tryCount = Integer.parseInt(input);

        return tryCount > 0;
    }
}
