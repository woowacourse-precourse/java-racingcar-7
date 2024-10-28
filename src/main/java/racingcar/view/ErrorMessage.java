package racingcar.view;

public enum ErrorMessage {

    CAR_NAME_IS_DUPLICATED("자동차의 이름은 중복될 수 없습니다."),
    CAR_NAME_IS_EMPTY("자동차의 이름은 빈 문자열일 수 없습니다."),
    CAR_NAME_IS_SPACE("자동차의 이름은 공백일 수 없습니다."),
    CAR_NAME_IS_TOO_LONG("자동차의 이름은 5자 이하만 가능합니다."),
    DECIMAL_MOVING_COUNT("이동 횟수는 소수일 수 없습니다."),
    INVALID_MOVING_COUNT("이동 횟수는 숫자만 가능합니다."),
    NEGATIVE_MOVING_COUNT("이동 횟수는 음수일 수 없습니다."),
    NO_INPUT("입력이 없습니다."),
    TOO_MANY_MOVING_COUNT("이동 횟수가 너무 많습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
