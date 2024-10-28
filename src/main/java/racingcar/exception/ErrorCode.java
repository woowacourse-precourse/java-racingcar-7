package racingcar.exception;

public enum ErrorCode {
    INVALID_CAR_CNT("경기는 최소 2명부터 참여 가능합니다."),
    INVALID_CAR_NAME_LENGTH("자동차 이름은 5자 이하로만 작성 가능합니다."),
    INVALID_ATTEMPTS_CNT("시도할 수 있는 횟수는 1회 이상입니다."),
    INVALID_TYPE("시도 횟수는 숫자만 입력 가능합니다.");

    private final String message;
    private final String ERROR = "[ERROR] ";

    ErrorCode(String message) {
        this.message = ERROR + message;
    }

    public String getMessage() {
        return this.message;
    }
}
