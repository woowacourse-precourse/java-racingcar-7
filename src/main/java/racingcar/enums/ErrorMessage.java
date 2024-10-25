package racingcar.enums;

import java.text.MessageFormat;

public enum ErrorMessage {
    CAR_NAME_LENGTH("자동차 이름은 5글자 이하로 입력해주세요."),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage(Object... params) {
        return MessageFormat.format(this.message, params);
    }
}
