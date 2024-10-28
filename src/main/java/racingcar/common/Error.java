package racingcar.common;

public enum Error {
    NAME_CANNOT_EXCEED_MAX_LENGTH("자동차 이름은 다섯 글자를 초과할 수 없습니다."),
    NOT_EMPTY_CAR_LIST("경주에 참여할 자동차가 없습니다."),
    NOT_NULL_OR_EMPTY_NAME("이름에는 빈값이 들어갈 수 없습니다."),
    ONLY_INT_NUMBER(Integer.MAX_VALUE + " 까지의 숫자만 입력 가능합니다."),
    NOT_NEGATIVE("시도할 횟수는 음수가 될 수 없습니다."),
    NOT_DUPLICATED_NAME("자동차 이름은 중복될 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
