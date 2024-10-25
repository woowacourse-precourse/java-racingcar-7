package racingcar.common;

public enum Constant {
    DELIMITER(",");

    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
