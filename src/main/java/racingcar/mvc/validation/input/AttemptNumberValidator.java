package racingcar.mvc.validation.input;

import java.math.BigInteger;

public class AttemptNumberValidator {
    public static void isValid(String input) {
        isEmpty(input);

        isPositiveNumber(input);
    }

    private static void isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("입력하지 않았습니다.");
        }
    }

    private static void isPositiveNumber(String input) {
        try {
            BigInteger number = new BigInteger(input);

            isPositive(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력한 값은 숫자가 아닙니다.");
        }
    }

    private static void isPositive(BigInteger number) {
        if (number.compareTo(BigInteger.ZERO) < 0) {
            throw new IllegalArgumentException("입력한 값은 양의 정수가 아닙니다.");
        }
    }
}
