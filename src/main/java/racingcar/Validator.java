package racingcar;

import java.util.List;

public class Validator {

    private static final int MAX_NAME_LENGTH = 5;

    public static void validateName(List<String> names) {
        for (String name : names) {
            validateNull(name);
            validateLength(name);
        }
    }

    public static int validateCycle(String cycleInput) {
        validateNull(cycleInput);
        validateParseInt(cycleInput);
        return validateNegativeNumber(parseValidatedString(cycleInput));
    }

    private static void validateNull(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException();
    }

    private static void validateLength(String input) {
        if (input.length() > MAX_NAME_LENGTH)
            throw new IllegalArgumentException();
    }

    private static void validateParseInt(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static int validateNegativeNumber(int inputNumber) {
        if (inputNumber <= 0)
            throw new IllegalArgumentException();
        return inputNumber;
    }

    private static int parseValidatedString(String cycleInput) {
        return Integer.parseInt(cycleInput);
    }

}
