package racingcar.message;

public enum ExceptionMessage {

    EMPTY_NAME_INPUT("빈 문자열만 입력하면 안됩니다."),
    NEGATIVE_ATTEMPT_INPUT("시도 횟수는 양수여야 합니다."),
    CAR_NAME_OVER_FIVE_LENGTH("차 이름은 5자 이하여야 합니다."),
    CAR_NAME_NOT_BLANK("차 이름은 공백이면 안됩니다."),
    DUPLICATED_CAR_NAME("차 이름이 중복되면 안됩니다."),
    NOT_CONVERTED_STRING("숫자로 변환할 수 없는 값입니다."),
    POSITION_UNDER_ZERO("위치가 0보다 작습니다. 출력할 수 없습니다");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
