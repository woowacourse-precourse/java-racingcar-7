package racingcar.enums;

import java.util.regex.Pattern;

public enum RegexPattern {

    STARTS_WITH_COMMA(Pattern.compile("^,")),
    ENDS_WITH_COMMA(Pattern.compile(",$")),
    VALID_NAME_FORMAT(Pattern.compile("^[a-zA-Z0-9가-힣 ]+$")),
    NO_CONTAIN_NUMBER(Pattern.compile(".*[\\D].*"));


    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }

    public boolean find(String input) {
        return pattern.matcher(input).find();
    }
}
