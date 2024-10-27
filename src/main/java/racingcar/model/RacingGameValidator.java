package racingcar.model;

import java.util.regex.Pattern;

public class RacingGameValidator {

    private static final String POSITIVE_NUMBER_PATTERN = "^[1-9][0-9]*$";
    private static final String INVALID_NUM_ATTEMPTS_ERROR_MESSAGE = "부적절한 형식의 시도 횟수를 입력했습니다. (시도 횟수는 양수)";
    private static final int MAX_ATTEMPTS = Integer.MAX_VALUE;
    private static final String EXCEEDS_MAX_ATTEMPTS_ERROR_MESSAGE = "입력된 시도 횟수가 허용된 최대 값을 초과했습니다.";

    public static void validate(String numAttempts) {
        if (numAttempts == null || isNotPositiveNumber(numAttempts)) {
            throw new IllegalArgumentException(INVALID_NUM_ATTEMPTS_ERROR_MESSAGE);
        }
        if (exceedsMaxAttempts(numAttempts)) {
            throw new IllegalArgumentException(EXCEEDS_MAX_ATTEMPTS_ERROR_MESSAGE);
        }
    }

    private static boolean isNotPositiveNumber(String numAttempts) {
        return !Pattern.matches(POSITIVE_NUMBER_PATTERN, numAttempts);
    }

    private static boolean exceedsMaxAttempts(String numAttempts) {
        return Long.parseLong(numAttempts) > MAX_ATTEMPTS;
    }
}
