package racingcar.validator;

import racingcar.exception.CarRacingException;
import racingcar.exception.ErrorMessage;

/**
 * CarNameValidator
 * - 자동차 이름 유효성 검사
 */
public class CarNameValidator {

    public static void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new CarRacingException(ErrorMessage.EMPTY_CAR_NAME);
        }

        if (name.length() > 5) {
            throw new CarRacingException(ErrorMessage.INVALID_CAR_NAME_LENGTH);
        }

        if (name.contains(" ")) {
            throw new CarRacingException(ErrorMessage.INVALID_CAR_NAME_SPACE);
        }
    }
}
