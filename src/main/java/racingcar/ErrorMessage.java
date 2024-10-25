package racingcar;

public enum ErrorMessage {
    ONE_CAR_NAME("자동차 경주는 최소 2대 이상입니다!"),
    TOO_LONG_CAR_NAME("이름의 길이가 5 보다 큽니다!"),
    NOT_NUMBER("시도 횟수는 숫자여야 합니다!"),
    TOO_BIG_NUMBER("시도 횟수가 너무 큽니다!"),
    NOT_POSITIVE_NUMBER("시도 횟수는 양의 정수여야 합니다!");


    private final String message;

    ErrorMessage(String value) {
        this.message = value;
    }

    public String getMessage() {
        return message;
    }
}