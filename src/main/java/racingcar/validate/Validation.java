package racingcar.validate;

import racingcar.constants.ErrorType;
import racingcar.constants.GameConstants;

import java.util.Set;

public class Validation {

    public static String validateCreateCar(String input, Set<String> distinctCarsName) {
        String carName = input.trim();
        validateInput(carName);
        validateNameLength(carName);
        validateDuplicateCarName(carName, distinctCarsName);
        return carName;
    }

    public static int validateTryGame(String count) {
        try {
            validateGameTryCount(Integer.parseInt(count));
            return Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorType.INVALID_NUMBER_FORMAT.getMessage());
        }
    }

    public static void validateInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.INPUT_NULL_ERROR.getMessage());
        }
    }

    private static void validateNameLength(String input) {
        if(input.trim().length() > GameConstants.MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorType.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    private static void validateDuplicateCarName(String input, Set<String> distinctCarsName) {
        if(!distinctCarsName.add(input)) {
            throw new IllegalArgumentException(ErrorType.CAR_NAME_DUPLICATE_ERROR.getMessage());
        }
    }

    private static void validateGameTryCount(int count) {
        if(count < GameConstants.MIN_GAME_TRY_COUNT) {
            throw new IllegalArgumentException(ErrorType.GAME_TRY_COUNT_ERROR.getMessage());
        }
    }

}
