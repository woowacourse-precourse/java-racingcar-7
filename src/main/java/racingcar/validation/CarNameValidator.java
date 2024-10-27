package racingcar.validation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.common.ExceptionCode;

public class CarNameValidator {

    public void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        validateUniqueName(carNames, uniqueNames);
        for (String name : uniqueNames) {
            validateIsBlank(name);
            validateCarNameLength(name);
        }
    }

    private void validateUniqueName(List<String> carNames, Set<String> uniqueNames) {
        if (carNames.size() != uniqueNames.size()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private static void validateIsBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_CAR_NAME.getMessage());
        }
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ExceptionCode.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }
}
