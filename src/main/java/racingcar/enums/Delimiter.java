package racingcar.enums;

public enum Delimiter {
    COLON(" : "),
    COMMA(", "),
    NEW_LINE("\n");

    private final String value;

    Delimiter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
