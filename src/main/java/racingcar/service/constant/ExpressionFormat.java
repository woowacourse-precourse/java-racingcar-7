package racingcar.service.constant;

public enum ExpressionFormat {

    VACANT(""),
    SEPARATOR(","),
    MID_PART_GHOST_CAR(",,"),
    ONLY_NUMBERS("[0-9]+"),
    WINNER_SEPARATOR(", ");

    private final String rule;

    ExpressionFormat(String format) {
        this.rule = format;
    }
    public String form() {
        return rule;
    }
}
