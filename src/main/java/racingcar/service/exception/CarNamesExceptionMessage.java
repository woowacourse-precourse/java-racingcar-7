package racingcar.service.exception;

import racingcar.exception.ExceptionMessage;

public enum CarNamesExceptionMessage implements ExceptionMessage {

    NO_INPUT("입력값이 없습니다"),
    INVALID_CAR_NAMES("자동차 이름은 한글, 영어, 숫자를, 구분자는 콤마를 사용해야 합니다."),
    CAR_NAMES_ONLY_COMMA("콤마만 입력했습니다."),
    INVALID_CAR_NAME("자동차 이름은 한글, 영어, 숫자를 사용해야 합니다."),
    CAR_NAME_MUST_UNDER_LENGTH_FIVE("자동차 이름은 5자 이하이어야 합니다."),
    CAR_NAME_DUPLICATED("중복된 자동차 이름이 존재합니다."),
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
