package racingcar.utils;

public class StringSeparator {
    private static final String DELIMITER = ",";

    public static String[] separate(String text) {
        return text.split(DELIMITER, -1);
    }

}
