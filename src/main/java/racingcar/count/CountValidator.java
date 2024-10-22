package racingcar.count;

import racingcar.constant.ErrorMessage;

public class CountValidator {
    private void checkIsEmpty(String attemptCount) {
        if (attemptCount.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_ATTEMPT_COUNT_EMPTY.getMessage());
        }
    }

}
