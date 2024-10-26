package racingcar.global;

public enum StepSymbol {

    EMPTY_STRING(""),
    STEP_STRING("-");

    private final String value;

    StepSymbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
