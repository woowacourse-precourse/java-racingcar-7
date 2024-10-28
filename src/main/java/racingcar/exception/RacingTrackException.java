package racingcar.exception;

public enum RacingTrackException {
    DUPLICATED_CAR_NAME("중복된 이름이 존재합니다."),
    NOT_ENOUGH_CAR("자동차는 2대 이상이어야 합니다."),
    TOO_MANY_CAR("자동차는 10대 이하이어야 합니다.");

    private final String message;

    RacingTrackException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
