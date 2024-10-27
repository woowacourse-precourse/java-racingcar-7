package racingcar.io;

import java.util.Arrays;
import racingcar.constants.ExceptionMessages;

public class RaceInputValidator {

    public void validateCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new IllegalArgumentException(ExceptionMessages.CAR_NAME_EMPTY);
        }

        Arrays.stream(carNames.split(","))
                .map(String::trim)
                .forEach(this::validateCarNameLength);
    }

    public void validateLapCount(int lapCount) {
        if (lapCount < 1) {
            throw new IllegalArgumentException(ExceptionMessages.LAP_COUNT_LACK);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessages.CAR_NAME_LENGTH_EXCEED);
        }
    }
}