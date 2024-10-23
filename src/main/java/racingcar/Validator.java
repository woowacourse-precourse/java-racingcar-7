package racingcar;

import java.util.List;

public class Validator {

    public void validateName(List<String> names) {
        for (String name : names) {
            validateNull(name);
            validateLength(name);
        }
    }

    public int validateCycle(String cycleInput) {
        int cycle;
        validateNull(cycleInput);
        cycle = validateParseInt(cycleInput);
        validateNegativeNumber(cycle);
        return cycle;
    }

    private static void validateNull(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException();
    }

    private static void validateLength(String name) {
        if (name.length()>5) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNegativeNumber(int cycle) {
        if (cycle <= 0)
            throw new IllegalArgumentException();
    }

    private static int validateParseInt(String cycleInput) {
        int cycle;
        try {
            cycle = Integer.parseInt(cycleInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
        return cycle;
    }
}
