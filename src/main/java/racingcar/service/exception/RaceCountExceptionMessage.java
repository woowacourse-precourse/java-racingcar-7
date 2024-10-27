package racingcar.service.exception;

import racingcar.exception.ExceptionMessage;

public enum RaceCountExceptionMessage implements ExceptionMessage {

    RACE_COUNT_CANNOT_BLANK("게임 횟수는 빈 문자열 또는 공백문자일 수 없습니다."),
    RACE_COUNT_MUST_DIGIT("게임 횟수는 숫자이어야 합니다."),
    RACE_COUNT_OVERFLOW("게임 횟수 오버플로우입니다."),
    RACE_COUNT_UNDERFLOW("게임 횟수를 언더플로우입니다."),
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
