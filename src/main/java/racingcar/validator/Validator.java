package racingcar.validator;

public final class Validator {

    public static void validateCarNamesInput(String input) {
        validateNotEmpty(input);
        validateContainsBlank(input);
        validateNameLengthOver(input);

    }

    public static void validateTotalRoundInput(String input) {
        validateNumber(input);
        validateAboveZero(input);
    }

    private static void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("Car name is empty");
        }
    }

    private static void validateContainsBlank(String input) {
        if (input.contains(" ")) {
            throw new IllegalArgumentException("Car names input contains blank");
        }
    }

    private static void validateNameLengthOver(String input) {
        for (String carName : input.split(",")) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name length must be below 5");
            }
        }
    }


    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("Total round must be integer number");
        }
    }

    private static void validateAboveZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException("Total round must be greater than zero");
        }
    }
}
