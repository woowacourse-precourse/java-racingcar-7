package racingcar.constant;

public enum ErrorMessage {
    EMPTY_NAME("유효하지 않은 이름입니다. 공백은 이름이 될 수 없습니다."),
    OVER_LIMITED_NAME("자동차 이름은 5글자 이내입니다."),
    NOT_VALID_TOTAL_ROUND_NUMBER("유효하지 않은 값입니다. 자연수를 입력해주세요."),
    EXCEPTION("예기치 못한 문제가 발생했습니다."),
    LOG_FOR_DEVELOPER("[개발자용 로그]: ");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return errorMessage;
    }
}
