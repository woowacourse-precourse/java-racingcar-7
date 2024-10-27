package view;

public enum ErrorMessage {
    CAR_NAME_OVER_SIZE_ERROR("자동차의 이름은 5글자를 넘을 수 없습니다."),
    CAR_NAME_NULL_ERROR("자동차의 이름을 입력하지 않았습니다."),
    TRY_NUM_NOT_DIGIT_ERROR("시도 횟수는 숫자여야 합니다."),
    TRY_NUM_NULL_ERROR("시도 횟수를 입력하지 않았습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String print() {
        return message;
    }
}
