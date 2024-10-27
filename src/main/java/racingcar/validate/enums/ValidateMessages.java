package racingcar.validate.enums;

public enum ValidateMessages {

    CAR_CANNOT_BE_NULL_OR_EMPTY("자동차 이름을 지어주세요."),
    CAR_NAME_LENGTH_CANNOT_BE_OVER_FIVE("자동차 이름은 5글자 이하여야 합니다."),
    CAR_NAME_CANNOT_CONTAIN_NEWLINE("자동차 이름에 개행 문자가 존재할 수 없습니다."),
    CAR_NAME_SHOULD_NOT_CONTAIN_WHITESPACE("자동차 이름은 공백을 포함할 수 없습니다.");

    private final String validateMessage;

    ValidateMessages(String validateMessage) {
        this.validateMessage = validateMessage;
    }

    public String getValidateMessage() {
        return validateMessage;
    }
}
