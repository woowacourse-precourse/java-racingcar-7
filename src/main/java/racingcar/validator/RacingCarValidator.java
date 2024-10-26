package racingcar.validator;

import racingcar.enums.ErrorMessage;

public class RacingCarValidator {

    public void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getMessage());
        }
    }
}
