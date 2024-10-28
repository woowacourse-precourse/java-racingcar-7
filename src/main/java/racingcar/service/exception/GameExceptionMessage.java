package racingcar.service.exception;

import racingcar.exception.ExceptionMessage;

public enum GameExceptionMessage implements ExceptionMessage {

    WINNER_DOES_NOT_EXIST("우승자가 존재하지 않습니다."),
    ;

    private final String message;

    GameExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
