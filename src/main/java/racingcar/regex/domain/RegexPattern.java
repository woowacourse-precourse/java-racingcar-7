package racingcar.regex.domain;

import racingcar.regex.constant.RegexConstant;

import java.util.regex.Pattern;

public enum RegexPattern {
    CAR_INPUT_REGEX_PATTERN(Pattern.compile(RegexConstant.CAR_INPUT_REGEX_PATTERN)),
    TRY_NUMBER_INPUT_REGEX_PATTERN(Pattern.compile(RegexConstant.POSITIVE_NUMBER));
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean match(String input) {
        return pattern.matcher(input).matches();
    }
}
