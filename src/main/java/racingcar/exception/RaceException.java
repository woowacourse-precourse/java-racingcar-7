package racingcar.exception;

public enum RaceException {
    WRONG_INPUT("입력이 잘못되었습니다.")
    ;

    private final String description;

    RaceException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
