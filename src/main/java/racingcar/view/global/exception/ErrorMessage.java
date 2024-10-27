package racingcar.view.global.exception;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    BLANK_CAR_NAME_ERROR("자동차 이름이 비어 있거나 공백일 수 없습니다."),
    CAR_NAME_TOO_LONG_ERROR("자동차 이름이 최대 길이를 초과했습니다."),
    DUPLICATE_CAR_NAME_ERROR("중복된 자동차 이름이 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
