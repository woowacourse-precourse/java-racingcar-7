package racingcar.util.message;

public enum ExceptionMessage {

    DELIMITER_POSITION_INCORRECT("쉼표(,)가 잘못 사용되었습니다."),
    NEED_MULTIPLE_RACING_CAR("자동차 1대로는 자동차 경주를 진행할 수 없습니다."),
    NAME_LENGTH_NOT_VALID("이름의 길이가 맞지 않습니다."),
    DUPLICATED_NAMES("중복된 이름이 포함되어 있습니다."),
    TRIAL_COUNT_NOT_POSITIVE("숫자 뽑기 횟수가 양수가 아닙니다.");

    private final String exceptionMessage;

    ExceptionMessage(String exceptionMessage) {
        this.exceptionMessage = exceptionMessage;
    }

    public String get() {
        return String.format("[ERROR] %s\n", exceptionMessage);
    }
}
