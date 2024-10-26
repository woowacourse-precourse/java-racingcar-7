package racingcar.exception.domain;

public enum RaceErrorMessage {
    CAR_NOT_FOUND("해당 이름의 자동차가 없습니다.");

    private final String message;

    RaceErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
