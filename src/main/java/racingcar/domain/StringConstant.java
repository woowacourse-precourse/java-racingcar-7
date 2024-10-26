package racingcar.domain;

public enum StringConstant {

    POSITION_MARK("-"),
    WINNER_MESSAGE("최종 우승자 : %s"),
    POSITION_MESSAGE("%s : %s%n"),
    COMMON_WINNER_DELIMITER(", "),
    NAME_DELIMITER(",");

    private final String value;

    StringConstant(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
