package racingcar.regex.constant;

public class RegexConstant {
    private static final String COMMA = ",";
    private static final String ONE_OR_MORE = "+";
    private static final String START_OF_STRING = "^";
    private static final String END_OF_STRING = "$";
    private static final String CAR_NAME_REGEX = "[^,\\s]+(?:\\s+[^,\\s]+)*";
    private static final String NON_CAPTURING_GROUP = "?:";

    public static final String CAR_INPUT_REGEX_PATTERN =
            START_OF_STRING + CAR_NAME_REGEX +
                    "(" + NON_CAPTURING_GROUP + COMMA + CAR_NAME_REGEX + ")" + ONE_OR_MORE + END_OF_STRING;

    public static final String POSITIVE_NUMBER = "^[1-9]*";

}
