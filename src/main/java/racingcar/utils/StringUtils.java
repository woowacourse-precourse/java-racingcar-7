package racingcar.utils;

public class StringUtils {
    public static boolean isNumericString(String str) {
        return str != null && str.matches("-?\\d+");
    }

    public static int convertStringToInteger(String str) {
        return Integer.parseInt(str);
    }
}
