package racingcar.exceptions;

import racingcar.constants.ErrorMessages;

public class ValidateError {

    public static void validateCarName(String carName) {
        if (carName == null || carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.NO_EXIST_CAR_NAME.getMessage());
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessages.EXCEED_CAR_NAME_LIMIT.getMessage());
        }
    }

    public static void validateTryNumber(Integer tryNum) {
        if (tryNum == null) {
            throw new IllegalArgumentException(ErrorMessages.NO_EXIST_TRY_NUMBER.getMessage());
        }
        if (tryNum <= 0) {
            throw new IllegalArgumentException(ErrorMessages.NEGATIVE_TRY_NUMBER.getMessage());
        }
    }
}
