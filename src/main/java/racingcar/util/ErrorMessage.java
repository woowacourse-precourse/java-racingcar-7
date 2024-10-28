package racingcar.util;

public enum ErrorMessage {
    CAR_NAME_LESS_THAN_FIVE("자동차의 이름은 5글자 이하가 되어야합니다."),
    CAR_NAME_NOT_BLANK_OR_EMPTY("자동차의 이름은 빈칸 혹은 공백일 수 없습니다."),
    CAR_NAME_DUPLICATED("자동차 이름이 중복되었습니다.: "),

    TRY_NUMBER_MORE_THAN_ZERO("시도 횟수는 0보다 큰 양수여야 합니다."),
    TRY_NUMBER_NOT_NUMBER("입력값이 숫자가 아닙니다.\n" + "입력값: "),
    ;

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
