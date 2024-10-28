package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static List<String> nameParse(String input) {
        return Arrays.stream(input.split(",")).toList();
    }

    public static int tryNumberParse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRY_NUMBER_NOT_NUMBER.getMessage() + input);
        }
    }
}
