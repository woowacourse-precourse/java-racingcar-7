package racingcar.enums;

import java.text.MessageFormat;

public enum ErrorMessage {
    INPUT_NOTHING("입력 문자열은 null이거나 비어있어서는 안 됩니다."),
    CAR_NAME_LENGTH("자동차 이름은 5글자 이하로 입력해주세요."),
    CAR_NAME_EMPTY("자동차 이름은 비어있어서는 안됩니다."),
    CAR_COUNT_MINIMUM("자동차의 수는 {0}개 보다 많아야 합니다."),
    CAR_NAME_UNIQUE("중복된 자동차 이름이 존재합니다."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}
