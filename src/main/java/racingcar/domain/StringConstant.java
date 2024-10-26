package racingcar.domain;

public enum StringConstant {

    POSITION_MARK("-");

    private final String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
