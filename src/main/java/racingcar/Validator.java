package racingcar;

import java.util.List;

public class Validator {

    public static void validateName(List<String> names) {
        for (String name : names) {
            validateNull(name);
            validateLength(name);
        }
    }

    public static int validateCycle(String cycleInput) {
        int cycle;
        validateNull(cycleInput);
        cycle = validateParseInt(cycleInput);
        validateNegativeNumber(cycle);
        return cycle;
    }

    private static void validateNull(String input) {
        if (input == null || input.isEmpty())
            throw new IllegalArgumentException();
    }

    private static void validateLength(String input) {
        if (input.length()>5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNegativeNumber(int inputNumber) {
        if (inputNumber <= 0)
            throw new IllegalArgumentException();
    }

    private static int validateParseInt(String inputNumber) {
        try {
             return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
