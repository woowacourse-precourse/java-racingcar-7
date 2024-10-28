package racingcar.utility;

public class StringUtil {

    public static boolean isNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
