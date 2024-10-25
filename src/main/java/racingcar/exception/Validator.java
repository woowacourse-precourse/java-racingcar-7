package racingcar.exception;

import camp.nextstep.edu.missionutils.Console;

public abstract class Validator {
    private static final int MAX_LENGTH = 5;
    private static final String DEFAULT_DELIMITER = ",";

    public static String validateNameLength(String names) {
        if (names.length() > MAX_LENGTH) {
            Console.close();
            throw new IllegalArgumentException();
        }
        return names;
    }

    public static int validateCountIfNegative(String count) {
        int countAsInt = Integer.parseInt(count);
        if (countAsInt < 0) {
            Console.close();
            throw new IllegalArgumentException();
        }
        return countAsInt;
    }

    public static void validateDelimiterFormatAndSingleRacer(String carNames) {
        if (!carNames.contains(DEFAULT_DELIMITER)) {
            Console.close();
            throw new IllegalArgumentException();
        }
    }
}
