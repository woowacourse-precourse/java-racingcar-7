package racingcar.common;

public enum ErrorMessage {
    NAME_LENGTH_ERROR("자동차 이름은 이름은 5자 이하만 가능합니다."),
    INVALID_TRY_COUNT("시도 횟수를 정확한 숫자로 입력해주세요."),
    INVALID_RANDOM_NUMBER("유요하지 않은 값입니다.");

    private final String message;

    ErrorMessage(final String errorMessage) {
        this.message = errorMessage;
    }

    public String getMessage() {
        return message;
    }
}
