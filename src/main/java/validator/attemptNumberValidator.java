package validator;

import java.math.BigInteger;

public class attemptNumberValidator {

    private static final BigInteger INT_MIN = BigInteger.ZERO;
    private static final BigInteger INT_MAX = BigInteger.valueOf(Integer.MAX_VALUE);

    public static void checkAttempt(String input) {
        isOutOfRange(input);
        int attempts = isNumeric(input);
        isAboveZero(attempts);

    }

    public static void isAboveZero(int input) {
        if (input <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
    }

    public static int isNumeric(String input) {
        try {
            return Integer.parseInt(input);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    public static void isOutOfRange(String input) {
        BigInteger value = new BigInteger(input);

        if (value.compareTo(INT_MIN) < 0) {
            throw new IllegalArgumentException("입력값이 최소값보다 작습니다.");
        }

        if (value.compareTo(INT_MAX) > 0) {
            throw new IllegalArgumentException("입력값이 최대값을 초과합니다.");
        }
    }


}
