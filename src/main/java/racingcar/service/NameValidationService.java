package racingcar.service;

import racingcar.constant.Constants;

import java.util.HashSet;
import java.util.Set;

public class NameValidationService {

    public void checkForDuplicateCarNames(String[] carNames) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            if (!uniqueNames.add(name)) {
                throw new IllegalArgumentException(Constants.DUPLICATE_CAR_NAME);
            }
        }
    }

    public void validateCarNames(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAME_LENGTH);
        }
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(Constants.INVALID_CAR_NAME_EMPTY);
        }
    }

}
