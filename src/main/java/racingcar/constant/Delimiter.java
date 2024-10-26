package racingcar.constant;

public enum Delimiter {
    COMMA(","), COMMA_WITH_SPACE(", ");

    private final String value;

    private Delimiter(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
