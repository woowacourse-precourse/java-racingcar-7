package racingcar.infrastructure.exception;

public enum ErrorCode {
    CONSECUTIVE_COMMA("입력에 쉼표가 연속적으로 입력되었습니다."),
    CAR_NAME_LENGTH_EXCEEDED("자동차 이름은 5자를 초과할 수 없습니다."),
    CAR_NAME_EMPTY("자동차 이름은 빈 문자열일 수 없습니다."),
    ROUNDS_LESS_THAN_ONE("시도 횟수는 1 이상이어야 합니다."),
    ROUND_EMPTY("시도 횟수는 빈 값일 수 없습니다."),
    ROUND_NOT_NUMBER("시도 횟수는 숫자여야 합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
