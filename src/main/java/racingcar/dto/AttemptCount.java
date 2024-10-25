package racingcar.dto;

import static racingcar.common.exception.ErrorMessage.*;

import racingcar.common.exception.RacingCarException;

public record AttemptCount(int value) {

    public static AttemptCount from(String attemptCount) {
        validateIsNumeric(attemptCount);
        int parsedAttemptCount = convertToInt(attemptCount);
        validateRange(parsedAttemptCount);
        return new AttemptCount(parsedAttemptCount);
    }

    private static int convertToInt(String attemptCount) {
        return Integer.parseInt(attemptCount);
    }

    private static void validateRange(int attemptCount) {
        if (attemptCount < 1 || attemptCount > 20) {
            throw RacingCarException.from(ATTEMPT_COUNT_OUT_OF_RANGE);
        }
    }

    private static void validateIsNumeric(String input) {
        if (!input.matches("\\d+")) {
            throw RacingCarException.from(ATTEMPT_COUNT_MUST_BE_NUMERIC);
        }
    }
}
