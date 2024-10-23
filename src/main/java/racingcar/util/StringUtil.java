package racingcar.util;

public class StringUtil {
    public static String[] getCarNames(String text) {
        String[] names = text.split(",");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].strip();
        }
        return names;
    }
}
