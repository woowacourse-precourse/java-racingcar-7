package racingcar.exception;

public enum RaceException {
    SPACING_NOT_ALLOWED("띄어쓰기는 입력할 수 없습니다."),
    ;

    private final String description;

    RaceException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
