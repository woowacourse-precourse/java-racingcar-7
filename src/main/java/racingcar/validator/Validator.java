package racingcar.validator;

public final class Validator {
    public static void validateTotalRoundInput(String input) {
        validateNumber(input);
        validateAboveZero(input);
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
