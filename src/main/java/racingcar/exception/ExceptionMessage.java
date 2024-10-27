package racingcar.exception;

public enum ExceptionMessage {

    INPUT_BLANK("값을 입력하지 않으셨습니다."),
    TRY_COUNT_OUT_OF_RANGE("최소 %d번, 최대 %d번까지 시도 가능합니다."),
    CARS_OUT_OF_RANGE("최소 %d명부터 최대 %d명까지 경주가 가능합니다."),
    NAME_BLANK("이름은 공백없이 최소 %d자부터 가능합니다."),
    NAME_OUT_OF_RANGE("이름은 최대 %d자까지 가능합니다."),
    WRONG_NAME_FORMAT("이름에 특수문자를 포함할 수 없으며, 콤마로 이름을 구분해 주세요."),
    DUPLICATED_NAME("중복된 이름이 존재합니다."),
    WRONG_TRIAL_COUNT_FORMAT("숫자만 입력하실 수 있습니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String formatMessage(Object... args) {
        return String.format(message, args);
    }
}
