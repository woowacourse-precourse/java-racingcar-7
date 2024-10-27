package racingcar.constant;

public enum SeparatorConstant {
    COMMA(","),
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
