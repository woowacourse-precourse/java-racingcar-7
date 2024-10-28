package racingcar.util;

public enum InputRegexConst {
    RACERS_NAME_REGEX("^([^,]{1,5})(,[^,]{1,5})*$"),
    LAPS_NUMBER_REGEX("^[1-9]\\d*$");

    private final String regex;

    InputRegexConst(final String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return this.regex;
    }
}
