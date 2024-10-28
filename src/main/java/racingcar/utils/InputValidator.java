package racingcar.utils;

public class InputValidator {

    public static String[] validateCarNames(String input) {
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
}
