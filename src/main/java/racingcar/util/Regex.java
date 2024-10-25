package racingcar.util;

public enum Regex {
    ONLY_DIGIT("^[0-9]*$"),
    ;


    String regularExpression;

    Regex(String regularExpression) {
        this.regularExpression = regularExpression;
    }

    public String getRegex() {
        return regularExpression;
    }
}
