package racingcar.validator;

import static racingcar.validator.ErrorMessage.CAR_NAME_LENGTH_ERROR;

public class RacingCarValidator {
    private static final Integer NAME_MIN_LENGTH = 1;
    private static final Integer NAME_MAX_LENGTH = 5;

    public RacingCarValidator() {
    }

    public void validateCarName(String carName) {
        if (carName.length() < NAME_MIN_LENGTH || carName.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }
}
