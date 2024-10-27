package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarException;

public class CarNameValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;

    private CarNameValidator() {
    }


    public static void validateCarNames(List<String> carNames) {
        validateNotEmptyList(carNames);
        for (String carName : carNames) {
            validateEmptyName(carName);
            validateNameLength(carName);
        }
        validateDistinctName(carNames);
    }

    private static void validateNotEmptyList(List<String> carNames) {
        if (carNames == null || carNames.isEmpty()) {
            throw new RacingCarException(ErrorMessage.EMPTY_CAR_NAMES);
        }
    }

    private static void validateEmptyName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new RacingCarException(ErrorMessage.EMPTY_CAR_NAME);
        }
    }

    private static void validateNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new RacingCarException(ErrorMessage.CAR_NAME_TOO_LONG);
        }
    }

    private static void validateDistinctName(List<String> carNames) {
        Set<String> distinctCarNames = new HashSet<>(carNames);
        if (carNames.size() != distinctCarNames.size()) {
            throw new RacingCarException(ErrorMessage.DUPLICATED_CAR_NAME);
        }
    }
}
