package racingcar.dto;

import static racingcar.common.exception.ErrorMessage.*;

import racingcar.common.exception.RacingCarException;
import java.util.List;

public record RacingCarNames(String input) {

    public RacingCarNames {
        validateInput(input);
    }

    private void validateInput(String input) {
        List<String> carNames = List.of(input.split(","));
        validateMinimumTwoCars(carNames);
        validateEachCarName(carNames);
    }

    private void validateMinimumTwoCars(List<String> carNames) {
        if (carNames.size() < 2) {
            throw RacingCarException.from(RACING_CAR_MINIMUM_TWO_REQUIRED);
        }
    }

    private void validateEachCarName(List<String> carNames) {
        carNames.forEach(this::validateSingleCarName);
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
