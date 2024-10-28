package racingcar.validator;

import racingcar.exception.ErrorMessage;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void carNameStringNotNull(String carNameString) {
        if (carNameString == null || carNameString.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_NOT_NULL.getMessage());
        }
    }

    public static void carNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_OVER_FIVE.getMessage());
        }
    }

    public static void carNameDuplicated(List<String> CarNameList) {
        Set<String> uniqueCarNames = new HashSet<>(CarNameList);

        if (CarNameList.size() > uniqueCarNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_MUST_UNIQUE.getMessage());
        }
    }

    public static void roundCountStringNotNull(String roundCountString) {
        if (roundCountString == null || roundCountString.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_MUST_BE_NOT_NULL.getMessage());
        }
    }

    public static void isRoundCountNumeric(String roundCountString) {
        try {
            Integer.parseInt(roundCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ROUND_COUNT_MUST_BE_NUMERIC.getMessage());
        }
    }

    public static void roundCountPositive(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ROUND_COUNT_MUST_BE_POSITIVE.getMessage());
        }
    }
}
