package racingcar.exception;

public enum RaceException {
    SPACING_NOT_ALLOWED("띄어쓰기는 입력할 수 없습니다."),
    INPUT_VALUE_EMPTY("값이 비어있습니다."),
    ARGUMENT_SIZE_UNSATISFIED("자동차 이름은 두 개 이상 작성해야 합니다."),
    ;

    private final String description;

    RaceException(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
