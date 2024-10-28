package racingcar.util;

public enum UtilConstants {

    COLON(" : "),
    DISTANCE("-"),
    DELIMITER(",");

    private final String value;

    UtilConstants(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
