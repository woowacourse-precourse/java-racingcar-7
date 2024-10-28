package racingcar.enums;

public enum StringPattern {
    CAR_NAME_SEPARATOR(","),
    MOVE_FORWARD("-"),
    JOIN_SYMBOL(", "),
    NAME_VIEWPOINT(" : ");
    private String value;

    StringPattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
