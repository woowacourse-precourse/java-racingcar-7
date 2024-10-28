package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class OverLimitedNameException extends IllegalArgumentException {
    @Override
    public String getMessage() {
        return ErrorMessage.OVER_LIMITED_NAME.toString();
    }
}
