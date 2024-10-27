package racingcar.utils;

public enum ErrorMessage {
    EMPTY_CAR_NAME("자동차 이름에 빈칸은 입력할 수 없습니다."),
    CAR_NAME_TOO_SHORT("자동차 이름은 최소 1글자 이상이어야 합니다."),
    CAR_NAME_TOO_LONG("자동차의 이름은 5글자 이하만 가능합니다."),
    DUPLICATE_CAR_NAME("자동차 이름은 중복될 수 없습니다."),
    NON_NUMERIC_TRY_COUNT("숫자만 입력 가능합니다."),
    NEGATIVE_TRY_COUNT("시도 횟수는 음수가 될 수 없습니다."),
    ZERO_TRY_COUNT("시도 횟수는 1 이상이어야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}