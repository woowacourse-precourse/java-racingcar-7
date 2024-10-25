package racingcar.utils;

public class StringParser {
    private static final String DELEMETER = ",";

    public static String[] separate(String text) {
        return text.split(DELEMETER);
    }

    public static int parseToInteger(String count) {
        return Integer.parseInt(count);
    }
}
