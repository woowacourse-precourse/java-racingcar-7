package racingcar.exception;

public enum RacingTrackException {
    DUPLICATED_CAR_NAME("중복된 이름이 존재합니다.");

    private final String message;

    RacingTrackException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
