package racingcar.validator;

import racingcar.exception.CarRacingException;
import racingcar.exception.ErrorMessage;

public class CarNameValidator {

    public static void validate(String name) {
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new CarRacingException(ErrorMessage.INVALID_CAR_NAME);
        }
    }
}
