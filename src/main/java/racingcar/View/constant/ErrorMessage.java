package racingcar.View.constant;

import racingcar.global.globalEnum.Message;

public enum ErrorMessage implements Message {
    TOO_LONG_VALUE("문자열은 5글자를 넘을 수 없습니다"),
    BLANK_VALUE("문자열은 비어있을 수 없습니다"),
    INVALID_INTEGER("시도횟수는 정수만 입력할 수 있습니다"),
    DUPLICATED("이름은 중복될 수 없습니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
