package racingcar;

public class Parser {

    private final String delimiter;
    public static String INVALID_STRING_FORMAT = "해석할 수 없는 문자열 입니다";

    public Parser(String delimiter) {
        this.delimiter = delimiter;
    }

    public String[] parsing(String str) {

        String[] parsedStrings = str.split(delimiter);
        for (String parsedString : parsedStrings) {
            if (parsedString.isEmpty()) {
                throw new IllegalArgumentException(INVALID_STRING_FORMAT);
            }
        }
        return parsedStrings;

    }
}
