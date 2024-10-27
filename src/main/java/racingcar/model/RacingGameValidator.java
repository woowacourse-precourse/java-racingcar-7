package racingcar.model;

import java.util.regex.Pattern;

public class RacingGameValidator {

    private static final String POSITIVE_NUMBER_PATTERN = "^[1-9][0-9]*$";
    private static final String INVALID_NUM_ATTEMPTS_ERROR_MESSAGE = "부적절한 형식의 시도 횟수를 입력했습니다. (시도 횟수는 양수)";

    public static void validate(String numAttempts) {
        if (numAttempts == null || isNotPositiveNumber(numAttempts)) {
            throw new IllegalArgumentException(INVALID_NUM_ATTEMPTS_ERROR_MESSAGE);
        }
    }

    private static boolean isNotPositiveNumber(String numAttempts) {
        return !Pattern.matches(POSITIVE_NUMBER_PATTERN, numAttempts);
    }
}
