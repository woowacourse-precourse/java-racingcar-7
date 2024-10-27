package racingcar.service.exception;

import racingcar.exception.ExceptionMessage;

public enum RaceCountExceptionMessage implements ExceptionMessage {

    RACE_COUNT_CANNOT_BLANK("게임 횟수는 빈 문자열 또는 공백문자일 수 없습니다."),
    ;

    private final String message;

    RaceCountExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String message() {
        return message;
    }
}
