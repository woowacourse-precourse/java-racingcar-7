package racingcar.global.exception;

public enum ExceptionType {
    INVALID_CAR_NAME("자동차 이름이 유효하지 않습니다.(1자 이상 5자 이하의 알파벳 혹은 숫자만 가능)"),
    INVALID_REPEAT_NUM("시도할 횟수는 숫자로 입력해야 합니다.");

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
