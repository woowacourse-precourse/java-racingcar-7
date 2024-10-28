package racingcar.common.support;

import static racingcar.common.constant.ExceptionMessage.NO_COUNT_NUMBER_FORMAT;

public class PositiveNumberParser {

    public static int parse(String value) {
        int number = parseToInt(value);
        validatePositive(number);
        return number;
    }

    private static void validatePositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(NO_COUNT_NUMBER_FORMAT);
        }
    }

    private static int parseToInt(String inputValue) {
        try {
            return Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NO_COUNT_NUMBER_FORMAT);
        }
    }
}
