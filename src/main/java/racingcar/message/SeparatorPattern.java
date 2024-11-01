package racingcar.message;

public enum SeparatorPattern {
    RESULT_SEPARATOR(" : "),
    MOVE_MARKER("-"),
    COMMA(",");

    private final String pattern;

    SeparatorPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getPattern() {
        return pattern;
    }
}
