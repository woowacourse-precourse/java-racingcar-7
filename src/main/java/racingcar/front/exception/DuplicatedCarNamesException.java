package racingcar.front.exception;

import racingcar.front.exception.message.ExceptionMessage;

public class DuplicatedCarNamesException extends IllegalArgumentException {
    public DuplicatedCarNamesException() {
        super(ExceptionMessage.DUPLICATED_CAR_NAME.getMessage());
    }
}
