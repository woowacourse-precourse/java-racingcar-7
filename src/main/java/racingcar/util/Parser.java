package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public static int toInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.DO_NOT_OVER_MAX.format());
        }
    }

    public static List<String> splitCarNames(String carName, String delimiter) {
        return Arrays.asList(carName.split(delimiter));
    }
}