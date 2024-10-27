package racingcar.count;

import racingcar.constant.ErrorMessage;
import racingcar.utils.StringUtils;

public class CountInputValidator {
    public void checkIsAttemptCountValid(String attemptCount) {
        checkIsEmpty(attemptCount);
        checkIsNumber(attemptCount);
        checkIsHaveValidRange(attemptCount);
    }

    private void checkIsEmpty(String attemptCount) {
        if (attemptCount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_EMPTY.getMessage());
        }
    }

    private void checkIsHaveValidRange(String attemptCount) {
        int count = StringUtils.convertStringToInteger(attemptCount);
        if (count <= 0 || count > 20) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_INVALID.getMessage());
        }
    }

    private void checkIsNumber(String attemptCount) {
        if (!StringUtils.isNumericString(attemptCount)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_NOT_A_NUMBER.getMessage());
        }
    }
}
