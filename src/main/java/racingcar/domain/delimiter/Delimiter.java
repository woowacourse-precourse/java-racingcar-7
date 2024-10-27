package racingcar.domain.delimiter;

public enum Delimiter {
    COMMA(","),
    SPACE_COMMA(", "),
    DASH("-");

    private final String delimiter;

    Delimiter(String delimiter) {
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }
}
