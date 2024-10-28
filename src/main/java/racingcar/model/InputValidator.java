package racingcar.model;

public class InputValidator {

    public static void validateTrialInput(String input) {
        try {
            isPositive(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_INPUT_IS_NOT_NUMBER);
        }
    }

    private static void isPositive(String input) {
        if (Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException(ErrorMessage.TRIAL_INPUT_IS_UNDER_ONE);
        }
    }

    public static void validateNameInput(String carName) {
        isEmpty(carName);
        isContainBlank(carName);
        isTooLong(carName);
    }

    private static void isTooLong(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.NAME_INPUT_IS_TOO_LONG);
        }
    }

    private static void isContainBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.NAME_INPUT_INCLUDE_SPACE);
        }
    }

    private static void isEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_INPUT_INCLUDE_NULL_STR);
        }
    }
}
