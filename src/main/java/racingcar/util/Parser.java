package racingcar.util;

public class Parser {

    private static final String DELIMITERS = ",";

    public static String[] parseDelimitersString(String delimitedString) {
        return delimitedString.split(DELIMITERS, -1);
    }

    public static int parseStringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 입력되어야 합니다.");
        }
    }
}