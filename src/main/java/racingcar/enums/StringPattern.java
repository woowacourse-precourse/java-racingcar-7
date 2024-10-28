package racingcar.enums;

public enum StringPattern {
    CAR_NAME_DELIMITER(","),
    MOVE_MARK("-"),
    TURN_RESULT_MARK(" : ");

    private String value;

    StringPattern(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
