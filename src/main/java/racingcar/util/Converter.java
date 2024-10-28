package racingcar.util;

public class Converter {

    public static Integer convert(String input) {
        return Integer.parseInt(input);
    }

    public static String convertPositionToBar(int position) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < position; i++) {
            builder.append("-");
        }
        return builder.toString();
    }
}
