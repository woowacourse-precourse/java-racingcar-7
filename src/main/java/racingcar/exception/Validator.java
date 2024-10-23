package racingcar.exception;

public class Validator {
    public static long isNumeric(String tryNumberInput) {
        long tryNumber;
        try {
            tryNumber = Long.parseLong(tryNumberInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.IS_NOT_NUMERIC);
        }

        return tryNumber;
    }

    public static String isNotBLANK(String carNameInput) {
        if (carNameInput.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.IS_BLANK);
        }
        return carNameInput;
    }
}
