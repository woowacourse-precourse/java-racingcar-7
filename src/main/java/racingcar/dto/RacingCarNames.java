package racingcar.dto;

import static racingcar.common.exception.ErrorMessage.*;

import racingcar.common.exception.RacingCarException;
import java.util.List;

public record RacingCarNames(List<String> carNames) {

    public static RacingCarNames from(String input) {
        List<String> carNames = List.of(input.split(","));
        validateInput(carNames);
        return new RacingCarNames(carNames);
    }

    private static void validateInput(List<String> carNames) {
        validateMinimumTwoCars(carNames);
        validateEachCarName(carNames);
    }

    private static void validateMinimumTwoCars(List<String> carNames) {
        if (carNames.size() < 2) {
            throw RacingCarException.from(RACING_CAR_MINIMUM_TWO_REQUIRED);
        }
    }

    private static void validateEachCarName(List<String> carNames) {
        carNames.forEach(RacingCarNames::validateSingleCarName);
    }

    private static void validateSingleCarName(String carName) {
        validateCarNameCharacters(carName);
        validateCarNameLength(carName);
    }

    private static void validateCarNameCharacters(String carName) {
        if (!carName.matches("^[a-zA-Z가-힣]+$")) {
            throw RacingCarException.from(RACING_CAR_NAME_MUST_BE_ENGLISH_OR_KOREAN);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw RacingCarException.from(RACING_CAR_NAME_MAX_LENGTH_EXCEEDED);
        }
    }
}
