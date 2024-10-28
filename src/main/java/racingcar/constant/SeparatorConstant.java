package racingcar.constant;

public enum SeparatorConstant {
    COMMA(","),
    COMMA_WITH_SPACE(", "),
    SPACE("\\s"),
    EMPTY("");


    private final String separator;

    SeparatorConstant(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
