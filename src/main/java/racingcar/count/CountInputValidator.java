package racingcar.count;

import racingcar.constant.ErrorMessage;
import racingcar.utils.StringUtils;

public class CountInputValidator {
    public void checkIsAttemptCountValid(String attemptCount) {
        checkIsEmpty(attemptCount);
        checkIsNumber(attemptCount);
        checkIsSmallThanZero(attemptCount);
    }

    private void checkIsEmpty(String attemptCount) {
        if (attemptCount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_EMPTY.getMessage());
        }
    }

    private void checkIsSmallThanZero(String attemptCount) {
        if (StringUtils.convertStringToInteger(attemptCount) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_INVALID.getMessage());
        }
    }

    private void checkIsNumber(String attemptCount) {
        if (!StringUtils.isNumericString(attemptCount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_NOT_A_NUMBER.getMessage());
        }
    }
}
