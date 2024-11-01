package racingcar.message;

import java.util.regex.Pattern;

public enum PatternMessage {
    VALID_FORMAT("\\d+"),
    INVALID_CHARACTERS("^[a-zA-Z가-힣]+$");

    private final Pattern pattern;

    PatternMessage(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    public boolean matches(String input) {
        return pattern.matcher(input).matches();
    }
}
