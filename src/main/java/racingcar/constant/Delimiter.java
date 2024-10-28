package racingcar.constant;

public enum Delimiter {
    DEFAULT(",")
    ;

    public final String regex;

    Delimiter(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
