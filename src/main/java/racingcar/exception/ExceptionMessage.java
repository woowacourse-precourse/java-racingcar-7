package racingcar.exception;

import racingcar.constant.Message;

public enum ExceptionMessage implements Message {
    INVALID_INPUT("잘못된 입력입니다."),
    EXCEED_MAX_INPUT_LENGTH(INVALID_INPUT.getMessage() + " [자동차 이름은 5글자를 초과할 수 없습니다.]"),
    INPUT_BLANK_IS_NOT_ALLOWED(INVALID_INPUT.getMessage() + " [공백은 입력이 불가능합니다.]"),
    INPUT_AT_LEAST_TWO_CAR(INVALID_INPUT.getMessage() + "[2개 이상의 자동차를 등록해주세요.]"),
    INPUT_ONLY_POSITIVE_INTEGER(INVALID_INPUT.getMessage() + "[1 이상의 정수만 입력 가능합니다.]"),
    DUPLICATE_INPUT(INVALID_INPUT.getMessage() + " [중복 입력은 불가능합니다.]");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
