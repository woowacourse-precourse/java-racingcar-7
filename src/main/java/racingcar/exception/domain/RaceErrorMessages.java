package racingcar.exception.domain;

public enum RaceErrorMessages {
    CAR_NOT_FOUND("해당 이름의 자동차가 없습니다."),
    RACE_NOT_START("경주가 아직 시작되지 않았습니다.");

    private final String message;

    RaceErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
