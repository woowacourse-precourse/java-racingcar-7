package racingcar.validator;

import racingcar.exception.ErrorCode;
import racingcar.exception.ExceptionHandler;

public class Validator {
    public void validateCarName(String name) {
        if (name == null || name.isEmpty() || name.length() > 5) {
            ExceptionHandler.throwIllegalArgException(ErrorCode.INVALID_CAR_NAME);
        }
    }

    public int validateTryCount(String attempts) {
        try {
            return validateAttempts(Integer.parseInt(attempts));
        } catch (NumberFormatException e) {
            ExceptionHandler.throwIllegalArgException(ErrorCode.TRY_COUNT_IS_NOT_NUMBER);
            return 0;
        }
    }

    private int validateAttempts(int attempts) {
        if (attempts < 1) {
            ExceptionHandler.throwIllegalArgException(ErrorCode.INVALID_TRY_COUNT);
        }
        return attempts;
    }
}
