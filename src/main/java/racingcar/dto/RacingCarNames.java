package racingcar.dto;

import static racingcar.common.exception.ErrorMessage.*;

import racingcar.common.exception.RacingCarException;

public record RacingCarNames(String input) {

    public RacingCarNames {
        validateInput(input);
    }

    private void validateInput(String input) {
        String[] carNames = input.split(",");
        validateMinimumTwoCars(carNames);
        validateEachCarName(carNames);
    }

    private void validateMinimumTwoCars(String[] carNames) {
        if (carNames.length < 2) {
            throw RacingCarException.from(RACING_CAR_MINIMUM_TWO_REQUIRED);
        }
    }

    private void validateEachCarName(String[] carNames) {
        for (String name : carNames) {
            validateSingleCarName(name);
        }
    }

    private void validateSingleCarName(String carName) {
        validateCarNameCharacters(carName);
        validateCarNameLength(carName);
    }

    private void validateCarNameCharacters(String carName) {
        if (!carName.matches("^[a-zA-Z가-힣]+$")) {
            throw RacingCarException.from(RACING_CAR_NAME_MUST_BE_ENGLISH_OR_KOREAN);
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw RacingCarException.from(RACING_CAR_NAME_MAX_LENGTH_EXCEEDED);
        }
    }
}
