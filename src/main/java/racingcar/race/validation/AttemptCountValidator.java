package racingcar.race.validation;

import racingcar.common.ExceptionEnum;
import racingcar.race.exception.AttemptCountException;

public class AttemptCountValidator {

    // 시도 횟수 검증
    public void validateAttemptCount(String attemptCountInput) {
        validateNumeric(attemptCountInput);

        long attemptCount = Long.parseLong(attemptCountInput);
        validateCountRange(attemptCount);
    }

    // 입력이 숫자(정수)인지 검증
    private void validateNumeric(String input) {
        if (input == null) {
            throw new AttemptCountException(ExceptionEnum.NULL_ATTEMPT_COUNT.getMessage());
        }

        if (input.trim().isEmpty()) {
            throw new AttemptCountException(ExceptionEnum.EMPTY_ATTEMPT_COUNT.getMessage());
        }

        try {
            Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new AttemptCountException(ExceptionEnum.NON_INTEGER_ATTEMPT_COUNT.getMessage());
        }
    }

    // 시도 횟수 값이 양수인지 검증
    private void validateCountRange(long attemptCount) {
        if (attemptCount < 0) {
            throw new AttemptCountException(ExceptionEnum.NEGATIVE_ATTEMPT_COUNT.getMessage());
        }
        if (attemptCount == 0) {
            throw new AttemptCountException(ExceptionEnum.ZERO_ATTEMPT_COUNT.getMessage());
        }
    }
}