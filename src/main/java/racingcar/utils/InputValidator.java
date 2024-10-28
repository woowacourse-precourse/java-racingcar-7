package racingcar.utils;

public class InputValidator {

    public static String removeAllSpaces(String input) {
        return input.trim().replaceAll("\\s", "");
    }

}
