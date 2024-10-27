package racingcar;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private final int CAR_NAME_LENGTH_LIMIT = 5;
    private final String CAR_NAME_LENGTH_ERROR_MESSAGE = "자동차 이름은 5자 이하만 가능합니다.";
    private final String CAR_NAME_EMPTY_ERROR_MESSAGE = "자동차 이름은 공백으로 구성될 수 없습니다.";
    private static final String CAR_NAME_DUPLICATE_ERROR_MESSAGE = "자동차 이름은 중복될 수 없습니다.";

    public void validateCarNames(List<String> carNames) {
        carNames.forEach(carName -> {
            validateCarNameLength(carName);
            validateCarNameNotEmpty(carName);
        });

        validateDuplicateNames(carNames);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(CAR_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateCarNameNotEmpty(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(CAR_NAME_EMPTY_ERROR_MESSAGE);
        }
    }

    private void validateDuplicateNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (uniqueNames.size() != carNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
        }
    }
}
