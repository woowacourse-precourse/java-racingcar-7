package racingcar.validator;

public enum ErrorMessages {
    // CarCountValidator 관련 메시지
    INVALID_CAR_COUNT("경주를 위해서 2개 이상의 차가 필요합니다."),

    // CarNameValidator 관련 메시지
    INVALID_CAR_NAME_BLANK("차 이름은 공백일 수 없습니다."),
    INVALID_CAR_NAME_LENGTH("차 이름은 %d자를 초과할 수 없습니다."),
    INVALID_CAR_NAME_DUPLICATE("차 이름에 중복된 값이 있습니다."),

    // RoundValidator 관련 메시지
    INVALID_ROUND_NOT_NUMBER("진행할 라운드를 정수로 입력해야합니다."),
    INVALID_ROUND_OUT_OF_RANGE("라운드 횟수가 int의 범위를 초과하였습니다."),
    INVALID_ROUND_MINIMUM("라운드는 최소 1번 이상 진행되어야합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(Object... args) {
        return String.format(message, args);
    }
}
