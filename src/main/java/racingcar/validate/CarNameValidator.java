package racingcar.validate;

import java.util.List;
import racingcar.ErrorMessage;

public abstract class CarNameValidator {

    private static void validateNoEdgeComma(String names) {
        if (names.startsWith(",") || names.endsWith(",")) {
            throw new IllegalArgumentException(
                ErrorMessage.CAR_NAME_NOT_CONTAINS_EDGE_COMMA.getMessage());
        }
    }

    private static void validateIsNotNullOrBlank(String names) {
        if (names == null || names.isBlank()) {
            throw new IllegalArgumentException(
                ErrorMessage.CAR_NAME_IS_BLANK.getMessage());
        }
    }

    private static void validateHasCommaSeparator(String names) {
        if (!names.contains(",")) {
            throw new IllegalArgumentException(
                ErrorMessage.CAR_NAMES_NOT_CONTAINS_COMMA.getMessage());
        }
    }

    private static void validateOnlyAllowedCharacters(String names) {
        if (!names.matches("^[a-zA-Z0-9,]*$")) {
            throw new IllegalArgumentException(
                ErrorMessage.CAR_NAMES_NOT_SPECIAL_CHAR.getMessage());
        }
    }

    private static void validateCarNamesLength(List<String> carNames) {
        carNames
            .forEach(name -> {
                if (name.length() > 5) {
                    throw new IllegalArgumentException(
                        ErrorMessage.CAR_NAME_LENGTH_OVER.getMessage());
                }
            });
    }

    private static void validateCarNamesCount(List<String> carNames) {
        if (carNames.size() < 2) {
            throw new IllegalArgumentException(
                ErrorMessage.CAR_COUNT_NOT_ENOUGH.getMessage());
        }
    }

    public static void validateCarNames(List<String> carNames) {
        validateCarNamesCount(carNames);
        validateCarNamesLength(carNames);
    }

    public static void validateCarNames(String carNames) {
        validateIsNotNullOrBlank(carNames);
        validateHasCommaSeparator(carNames);
        validateOnlyAllowedCharacters(carNames);
        validateNoEdgeComma(carNames);
    }
}
