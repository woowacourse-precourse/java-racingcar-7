package racingcar.validator;

import racingcar.enums.Constants;
import racingcar.enums.ErrorMessage;

public class RacingCarValidator {

    public void validateCarNames(String[] carNames) {
    }

    public void validateCarName(String carName) {
        validateCarNameLength(carName);
    }

    public void validateCarNameLength(String carName) {
        if (carName.length() > Constants.NAME_LENGTH_LIMIT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH.getMessage());
        }
    }
}
