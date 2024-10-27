package racingcar.common;

public enum Constant {
    DELIMITER(","),
    CAR_NAME_LIMIT_LENGTH("5"),
    MOVE_CONDITION("4"),
    OUTPUT_DELIMITER(":"),
    CAR_MOVE_SYMBOL("-"),
    WHITESPACE(" ");
    
    private final String value;

    Constant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
