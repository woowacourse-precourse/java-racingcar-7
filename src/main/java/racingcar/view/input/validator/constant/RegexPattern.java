package racingcar.view.input.validator.racingcar.constant;

import java.util.regex.Pattern;

public enum RegexPattern {
    INPUT_REGEX_PATTERN();
    private final Pattern pattern;
    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }
}
