package racingcar.constants;

public enum ErrorMessages {

    PREFIX("[ERROR] "),
    INVALID_USER_INPUT_BLANK("입력은 공백일 수 없습니다."),
    INVALID_RACER_NAME_BLANK("자동차 이름은 공백일 수 없습니다."),
    INVALID_RACER_NAME_RANGE("유효한 자동차 이름 길이가 아닙니다."),
    INVALID_RACER_NAME_DUPLICATED("자동차 이름은 중복될 수 없습니다."),
    INVALID_RANGE_TRY_COUNT("입력횟수는 1회 이상이어야 합니다."),
    INVALID_NOT_NUMBER_TRY_COUNT("입력 횟수는 숫자여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return PREFIX.message + message;
    }
}
