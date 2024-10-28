package racingcar.view;

import java.math.BigInteger;
import java.util.List;
import racingcar.exception.ErrorMessage;

public class InputValidator {
    private static final int MAX_LENGTH = 5;
    private static final String VALID_NAME_FORMAT = "^[a-zA-Z0-9]+$";

    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            isEmpty(name);
            isLengthOver(name);
            isValidFormat(name);
        }
    }

    public static void validateMaxRound(String inputRound) {
        isEmpty(inputRound);
        isNumeric(inputRound);
        isPositiveInteger(inputRound);
    }

    public static void isEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_INPUT.getMessage());
        }
    }

    public static void isLengthOver(String carName) {
        if (carName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.LENGTH_OVER.getMessage());
        }
    }

    public static void isValidFormat(String carName) {
        if (!carName.matches(VALID_NAME_FORMAT)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    // -------------------

    public static void isNumeric(String value) {
        if (!value.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMERIC.getMessage());
        }
    }

    public static void isPositiveInteger(String value) {
        if (Integer.parseInt(value) <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NEGATIVE_OR_ZERO.getMessage());
        }
    }
}
