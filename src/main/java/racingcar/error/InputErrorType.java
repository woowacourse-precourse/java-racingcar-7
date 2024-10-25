package racingcar.error;

import static racingcar.common.Constant.MAX_CAR_NAME_LENGTH;

public enum InputErrorType {
    INVALID_CAR_NAME_FORMAT("한글과 영어 소문자로 작성해주세요."),
    INVALID_CAR_NAME_LENGTH(MAX_CAR_NAME_LENGTH + "자 이하의 이름을 작성해주세요."),
    INVALID_CAR_NAME_DUPLICATION("중복되지 않은 이름을 입력해주세요."),

    INVALID_TRIAL_COUNT_TYPE("정수를 입력해주세요. (1 ~ 2147483647)"),
    INVALID_TRIAL_COUNT_RANGE("1 이상의 정수를 입력해주세요.");

    private final String message;

    InputErrorType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
