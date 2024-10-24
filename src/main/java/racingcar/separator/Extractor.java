package racingcar.separator;

public class Extractor {
    private static final String COMMA = ",";
    private static final String SPACE = " ";

    public static String[] extract(String input) {
        input = input.replaceAll(SPACE, "");

        return input.split(COMMA);
    }
}