package racingcar.validator;

public class TryCountValidator {
    public static void validateTryCount(String input) {
        if (!containsOnlyDigits(input)) {
            throw new IllegalArgumentException("[ERROR] 시도횟수는 숫자로만 입력되어야 합니다.");
        }

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] int 범위의 숫자로만 입력되어야 합니다.");
        }
    }

    private static boolean containsOnlyDigits(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
