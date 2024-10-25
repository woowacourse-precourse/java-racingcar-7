package racingcar.race.validation;

import racingcar.common.ExceptionEnum;
import racingcar.race.exception.AttemptCountException;

// 시도 횟수에 대한 검증 클래스
public class AttemptCountValidator {
    // 시도 횟수 검증 메서드
    public void validateAttemptCount(String attemptCountInput) {
        if (attemptCountInput == null || attemptCountInput.trim().isEmpty()) {
            throw new AttemptCountException(ExceptionEnum.NON_NUMERIC_ATTEMPT_COUNT.getMessage());
        }

        try {
            int attemptCount = Integer.parseInt(attemptCountInput);

            if (attemptCount < 0) {
                throw new AttemptCountException(ExceptionEnum.NEGATIVE_ATTEMPT_COUNT.getMessage());
            }

            if (attemptCount == 0) {
                throw new AttemptCountException(ExceptionEnum.ZERO_ATTEMPT_COUNT.getMessage());
            }

        } catch (NumberFormatException e) {
            throw new AttemptCountException(ExceptionEnum.NON_INTEGER_ATTEMPT_COUNT.getMessage());
        }
    }
}