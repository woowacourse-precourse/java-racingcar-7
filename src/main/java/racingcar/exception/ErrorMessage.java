package racingcar.exception;

public enum ErrorMessage {

    ERROR_INPUT_EMPTY_OR_NULL("[ERROR] 사용자 입력이 입력되지 않았습니다"),
    ERROR_INPUT_ONLY_POSITIVE("[ERROR] 숫자는 양수만 입력 가능합니다."),
    ERROR_INPUT_NAME_OVER_FIVE("[ERROR] 자동차 이름은 5자가 넘어가선 안됩니다"),
    ERROR_INPUT_ONLY_DIGIT("[ERROR] 구분자를 제외한 입력은 숫자만 입력해 주세요."),
    ERROR_INPUT_DELIMITER_ONLY_COMMA("[ERROR] 구분자는 쉼표(,)만 사용 가능합니다"),
    ERROR_INPUT_NO_EMPTY_BETWEEN_DELIMITER("[ERROR] 구분자(,) 사이에는 자동차 이름이있어야 합니다"),
    ERROR_INPUT_ONLY_ENG("[ERROR] 자동차 이름은 영어로만 구성되어야 합니다");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
