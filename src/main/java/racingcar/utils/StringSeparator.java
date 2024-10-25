package racingcar.utils;

public class StringSeparator {
    private static final String DELEMETER = ",";

    public static String[] separate(String text) {
        return text.split(DELEMETER);
    }

}
