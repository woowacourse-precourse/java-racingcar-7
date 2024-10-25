package racingcar.util;

public class Convertor {
    public static int convertStringToInt(String target) {
        try {
            Integer.parseInt(target);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(target);
    }
}
