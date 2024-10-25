package racingcar.utils.validation;

import racingcar.exception.RacingExceptionStatus;

import java.util.List;


public class CarNameValidation {

    public static void validate(List<String> carNames){
        for(String carName : carNames){
            checkCarNameBlank(carName);
            checkCarNameLength(carName);
        }
    }

    private static void checkCarNameLength(String carName) {
        if (carName.trim().length() > 5) {
            throw new IllegalArgumentException(RacingExceptionStatus.INVALID_NAME_LENGTH.getMessage());
        }
    }

    private static void checkCarNameBlank(String carName) {
        if (carName.equals(" ") || carName.isEmpty()) {
            throw new IllegalArgumentException(RacingExceptionStatus.INVALID_NAME_BLANK.getMessage());
        }
    }
}
