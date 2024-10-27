package racingcar.service.exception;

import racingcar.exception.ExceptionMessage;

public enum CarNamesExceptionMessage implements ExceptionMessage {

    NO_INPUT("입력값이 없습니다"),
    ;

    private final String message;

    CarNamesExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
