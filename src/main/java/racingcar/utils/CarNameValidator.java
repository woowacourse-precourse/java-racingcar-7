package racingcar.utils;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator implements InputValidator {
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final String CAR_NAME_DELIMITER = ",";

    @Override
    public void validate(String carNames) {
        if (isNullOrEmpty(carNames)) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_NULL_OR_EMPTY);
        }

        String[] names = carNames.split(CAR_NAME_DELIMITER);
        validateNames(names);
        checkUniqueNames(names);
    }

    private void validateNames(String[] names) {
        for (String name : names) {
            String trimmedName = name.trim();
            validateName(trimmedName);
        }
    }

    private void checkUniqueNames(String[] names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            if (!uniqueNames.add(name.trim())) {
                throw new IllegalArgumentException(ErrorMessages.CAR_NAME_DUPLICATE + name);
            }
        }
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private void validateName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_TOO_LONG + name);
        }
        if (name.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.CAR_NAME_EMPTY);
        }
    }
}
