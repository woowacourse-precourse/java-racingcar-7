package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Cars;
import racingcar.model.Game;
import racingcar.enums.ErrorMessage;

public class Validator {
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final String PRINTABLE_PATTERN = "\\p{Print}+";

    public static void carNamesValidate(List<String> carNames) {
        validateCarListSize(carNames);
        validateCarNames(carNames);
        checkForDuplicateNames(carNames);
    }

    private static void validateCarListSize(List<String> carNames) {
        if (carNames.isEmpty() || carNames.size() > Cars.MAX_CAR_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_CAR_LIST.getMessage());
        }
    }

    private static void validateCarNames(List<String> carNames) {
        for (String carName : carNames) {
            validateCarName(carName);
        }
    }

    private static void validateCarName(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERR_CAR_NAME_ISNULL.getMessage());
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INVALID_CAR_NAME_LENGTH.getMessage());
        }
        if (!carName.matches(VALID_NAME_PATTERN) || !carName.matches(PRINTABLE_PATTERN)) {
            throw new IllegalArgumentException(ErrorMessage.ERR_CAR_NAME_CONTAIN_INVALID_CHARACTER.getMessage());
        }
    }

    private static void checkForDuplicateNames(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>(carNames);
        if (uniqueCarNames.size() < carNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.ERR_NOT_ALLOW_DUPLICATED_NAME.getMessage());
        }
    }


    public static void gameRoundValidate(String input) {
        validateNullOrBlank(input);
        double number = parseToDouble(input);
        validatePositiveInteger(number);
        validateWithinMaxLimit(number);
    }

    private static void validateNullOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.ERR_NOT_ALLOW_NUMBER_INPUT.getMessage());
        }
    }

    private static double parseToDouble(String input) {
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ERR_INPUT_NUMBER_IS_NOT_VALID.getMessage());
        }
    }

    private static void validatePositiveInteger(double number) {
        if (number <= 0 || number != (int) number) {
            throw new IllegalArgumentException(ErrorMessage.ERR_NUMBER_MUST_BE_POSITIVE_NUMBER.getMessage());
        }
    }

    private static void validateWithinMaxLimit(double number) {
        if (number > Game.MAX_GAME_ROUND) {
            throw new IllegalArgumentException(ErrorMessage.ERR_NUMBER_CANT_OVER_MAX_LIMIT.getMessage());
        }
    }
}
