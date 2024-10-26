package racingcar.io;

import static racingcar.messages.ExceptionMessages.EMPTY_NAME;
import static racingcar.messages.ExceptionMessages.INVALID_CAR_NAME_FORMAT;
import static racingcar.messages.ExceptionMessages.INVALID_ROUNDS_INPUT;
import static racingcar.messages.ExceptionMessages.NAME_TOO_LONG;

public class InputValidator {
    public void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (!isValidNameLength(carName)) {
                throw new IllegalArgumentException(NAME_TOO_LONG.getMessage());
            }
            if (containsWhiteSpace(carName)) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT.getMessage());
            }
            if (isEmptyName(carName)) {
                throw new IllegalArgumentException(EMPTY_NAME.getMessage());
            }
        }
    }

    public void validateNumberOfRound(int numberOfRounds) {
        if (isPositiveRoundNumber(numberOfRounds)) {
            throw new IllegalArgumentException(INVALID_ROUNDS_INPUT.getMessage());
        }
    }

    private boolean isValidNameLength(String carName) {
        return carName.length() <= 5;
    }

    private boolean containsWhiteSpace(String carName) {
        return carName.contains(" ");
    }

    private boolean isPositiveRoundNumber(int roundLength) {
        return roundLength > 0;
    }

    private boolean isEmptyName(String carName) {
        return carName == null || carName.isEmpty();
    }
}
