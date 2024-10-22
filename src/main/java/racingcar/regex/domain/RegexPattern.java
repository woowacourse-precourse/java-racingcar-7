package racingcar.view.input.validator.constant;

import java.util.regex.Pattern;

public enum RegexPattern {
    CAR_INPUT_REGEX_PATTERN(Pattern.compile("^[a-zA-Z가-힣0-9]+(?:\\s[a-zA-Z가-힣0-9]+)*(?:,[a-zA-Z가-힣0-9]+(?:\\s[a-zA-Z가-힣0-9]+)*)+$")
    ),
    TRY_NUMBER_INPUT_REGEX_PATTERN(Pattern.compile("^[1-9]*"));
//    NONE_START_WITH_BLANK(Pattern.compile("^[a-zA-Z가-힣0-9]")),
//    NONE_END_WITH_BLANK(Pattern.compile("[a-zA-Z가-힣0-9]$"));
    private final Pattern pattern;

    RegexPattern(Pattern pattern) {
        this.pattern = pattern;
    }

    public boolean match(String input) {
        return pattern.matcher(input).matches();
    }

    public static void main(String[] args) {
        System.out.println(CAR_INPUT_REGEX_PATTERN.match("6213 ,123"));
//        System.out.println(TRY_NUMBER_INPUT_REGEX_PATTERN.match("213123123"));

    }
}
