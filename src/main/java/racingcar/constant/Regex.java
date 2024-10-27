package racingcar.constant;

public enum Regex {

    ALLOWED_CHARACTERS("[^a-zA-Z0-9,]|\\s|,,+");

    private final String value;

    private Regex(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
