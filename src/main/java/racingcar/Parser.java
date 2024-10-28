package racingcar;

public class Parser {

    private String delimiter;

    public Parser(String delimiter) {
        this.delimiter = delimiter;
    }

    public String[] parsing(String str) {

        String[] parsedStrings = str.split(delimiter);
        for (String parsedString : parsedStrings) {
            if (parsedString.isEmpty()) {
                throw new IllegalArgumentException("해석할 수 없는 문자열 입니다");
            }
        }
        return parsedStrings;

    }
}
