package racingcar.parser;

public enum ParserConfig {

    DEFAULT(",", 5, "^[가-힣A-Za-z0-9ㄱ-ㅎㅏ-ㅣ]*$");

    private final String delimiter;
    private final int nameMinimumLength;
    private final String regularExpression;

    ParserConfig(String delimiter, int nameMinimumLength, String regularExpression) {
        this.delimiter = delimiter;
        this.nameMinimumLength = nameMinimumLength;
        this.regularExpression = regularExpression;
    }

    public String getDelimiter() {
        return delimiter;
    }

    public int getNameMinimumLength() {
        return nameMinimumLength;
    }

    public String getRegularExpression() {
        return regularExpression;
    }
}
