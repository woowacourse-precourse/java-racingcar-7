package racingcar.constant;

public enum ErrorMessage {
    ERROR_IS_CAR_INPUT_EMPTY("적어도 1개 이상의 자동차 이름을 입력해야해요."),
    ERROR_IS_CAR_NAME_EMPTY("빈 값은 자동차 이름으로 사용할 수 없어요."),
    ERROR_IS_CAR_NAME_TO_LONG("자동차 이름은 5글자 이하만 입력할 수 있어요."),
    ERROR_IS_CAR_NAME_ALREADY_EXIST("이미 입력한 이름은 사용할 수 없어요."),

    ERROR_IS_ATTEMPT_COUNT_EMPTY("횟수는 빈 값일 수 없어요."),
    ERROR_IS_ATTEMPT_COUNT_INVALID("1 이상 20 이하의 숫자만 입력할 수 있어요."),
    ERROR_IS_ATTEMPT_COUNT_NOT_A_NUMBER("횟수는 숫자만 입력할 수 있어요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
