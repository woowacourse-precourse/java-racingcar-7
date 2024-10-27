package racingcar.constants;

public class RegexConstants {

    public static final String COMMA = ",";
    public static final String COMMA_SPACE = ", ";
    public static final String COLON = ":";

    private static final String HANGUL_PATTERN = "가-힣";
    private static final String ALPHABET_PATTERN = "a-zA-Z";
    private static final String NUMBER_PATTERN = "0-9";
    private static final String CAR_NAME_PATTERN = "[" + HANGUL_PATTERN + ALPHABET_PATTERN + NUMBER_PATTERN + "]+";
    public static final String INPUT_CARS_PATTERN = "^(" + CAR_NAME_PATTERN + "(" + COMMA + CAR_NAME_PATTERN + ")*)$";

    public static final String INTEGER_PATTERN = "^[1-9][0-9]*$";
}
