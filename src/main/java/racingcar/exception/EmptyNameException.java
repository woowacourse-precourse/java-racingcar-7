package racingcar.exception;

import racingcar.constant.ErrorMessage;

public class EmptyNameException extends IllegalArgumentException{

    @Override
    public String getMessage() {
        return ErrorMessage.EMPTY_NAME.toString();
    }
}
