package racingcar.count;

import racingcar.constant.ErrorMessage;
import racingcar.utils.StringUtils;

public class CountValidator {
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
}
