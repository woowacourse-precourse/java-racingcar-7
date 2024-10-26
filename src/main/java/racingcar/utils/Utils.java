package racingcar.utils;

public class Utils {
    private static final String NUMBER_REGEX = "^\\d+$";

    public static boolean isAtLeastFour(int number) {
        return number >= 4;
    }

    public static boolean isNumeric(String str) {
        return str.matches(NUMBER_REGEX);
    }
}
