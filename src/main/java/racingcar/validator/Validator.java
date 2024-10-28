package racingcar.validator;

public final class Validator {

    public static void validateCarNames(String input) {
        validateNotEmpty(input);
        validateNameLengthOver(input);
    }

    public static void validateTotalRoundInput(String input) {
        validateNumber(input);
        validateAboveZero(input);
    }

    public static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Car name is empty");
        }
    }

    public static void validateNameLengthOver(String input) {
        if (input.length() > 5) {
            throw new IllegalArgumentException("Car name length must be below 5");
        }
    }

    public static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Total round must be integer number");
        }
    }

    public static void validateAboveZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("Total round must be greater than zero");
        }
    }
}
