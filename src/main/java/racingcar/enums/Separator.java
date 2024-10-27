package racingcar.enums;

public enum Separator {

    COMMA(","),
    COMMA_SPACE(", ");

    private final String separator;

    Separator(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }
}
