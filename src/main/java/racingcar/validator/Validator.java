package racingcar.validator;

import racingcar.global.ErrorMessage;

public class Validator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            isLengthValid(carName);
            isContainSpace(carName);
        }
    }

    public void isLengthValid(String carName) {
        if (carName.isEmpty() || carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    public void isContainSpace(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_CAR_NAME_CONTAINS_SPACE.getMessage());
        }
    }

    public void validateRound(int round) {
        if (round <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ROUND_COUNT.getMessage());
        }
    }
}
