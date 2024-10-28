package racingcar.utils;

public enum ErrorMessages {
    CAR_COUNT_EMPTY("자동차가 한 대 이상 입력되어야 합니다."),
    CAR_COUNT_EXCEEDED("자동차는 최대 " + ValidationUtils.MAX_CAR_COUNT + "대까지 입력할 수 있습니다."),
    CAR_NAME_EMPTY("자동차 이름은 빈 문자열이나 공백일 수 없습니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하여야 합니다."),
    CAR_NAME_INVALID("자동차 이름은 알파벳과 숫자만 포함해야 합니다."),
    CAR_NAME_DUPLICATED("자동차 이름은 중복될 수 없습니다."),
    TRY_COUNT_INVALID("이동 횟수는 1 이상 " + ValidationUtils.MAX_TRY_COUNT + " 이하의 숫자여야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
