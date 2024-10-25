package racingcar;

public enum ErrorMessage {

    REPETITION_COUNT_NOT_A_NUMBER("시도 횟수는 숫자를 입력해주세요."),
    REPETITION_COUNT_IS_BLANK("시도 횟수를 입력해주세요."),
    REPETITION_COUNT_NOT_NEGATIVE("시도 횟수는 양수로 입력해주세요");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
