package racingcar.constant;

public enum ExceptionMessage {
    NULL_OR_EMPTY_INPUT("값을 입력해주세요."),
    INPUT_TOO_LONG("값이 너무 큽니다."),
    INVALID_NUMBER_FORMAT("숫자만 입력 가능합니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 %d자 이상 %d자 이하만 가능합니다"),
    INVALID_ROUND_MIN("라운드는 %d 이상이어야 합니다."),
    NO_CARS("자동차가 없습니다."),
    NO_MORE_ROUNDS("더 이상 진행할 라운드가 없습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
