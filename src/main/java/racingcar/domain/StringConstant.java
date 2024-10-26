package racingcar.domain;

public enum StringConstant {

    POSITION_MARK("-"),
    WINNER_MESSAGE("최종 우승자 : %s");

    private final String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
