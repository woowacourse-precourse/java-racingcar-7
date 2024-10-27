package racingcar.exception;

public enum ErrorMessage {

    //Car Name
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자를 초과할 수 없습니다."),
    INVALID_CAR_NAME_FORMAT("자동차 이름를 영문자와 숫자로만 입력해주세요."),
    DUPLICATE_CAR_NAME("자동차 이름이 중복되었습니다."),
    EMPTY_INPUT("입력 값은 공백이 될 수 없습니다."),
    MINIMUM_NUMBER_OF_CARS("자동차가 2개 미만일 경우 경주를 시작할 수 없습니다."),

    //Attempt Count
    INVALID_ATTEMPT_COUNT_FORMAT("숫자를 입력해주세요."),
    NEGATIVE_NUMBER("음수는 입력할 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
