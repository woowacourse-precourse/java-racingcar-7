package racingcar.common;

public enum Languages {
    ENGLISH("a-zA-Z"),
    KOREAN("ㄱ-ㅎㅏ-ㅣ가-힣");

    private final String regex;

    Languages(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
