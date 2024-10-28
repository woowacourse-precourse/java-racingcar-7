package racingcar.validator;

import static racingcar.utils.RaceErrorMessage.*;

public class RaceValidator {

    public void validateAttempt(String inputAttempt) {
        if (inputAttempt == null || inputAttempt.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_ATTEMPT_REQUIRED);
        }
        try {
            int attempts = Integer.parseInt(inputAttempt);
            if (attempts == 0) {
                throw new IllegalArgumentException(ERROR_ZERO_ATTEMPTS);
            }
            if (attempts < 0) {
                throw new IllegalArgumentException(ERROR_NEGATIVE_ATTEMPTS);
            }
        } catch (NumberFormatException e) { // 정수 형식이 아니거나, 오버플로우인 경우
            throw new IllegalArgumentException(ERROR_INVALID_ATTEMPT_FORMAT);
        }
    }
}