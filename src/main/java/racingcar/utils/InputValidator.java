package racingcar.utils;

public class InputValidator {

    public static String[] parseCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }

            if (name.trim().length() > 5) {
                throw new IllegalArgumentException();
            }
        }

        return names;
    }

    public static int parseTryCount(String input) {
        int count = Integer.parseInt(input);
        if (count <= 0) {
            throw new IllegalArgumentException();
        }
        return count;
    }
}
