package racingcar;

import racingcar.constant.ErrorMessage;

import java.util.HashSet;

public class CarNameValidator {
    public void checkIsCarNameValid(String carName, HashSet<String> carsToCheckDuplicate) {
        checkCarNameLength(carName);
        checkIsCarNameEmpty(carName);
        checkIsCarNameAlreadyExist(carName, carsToCheckDuplicate);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_TO_LONG.getMessage());
        }
    }

    private void checkIsCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_EMPTY.getMessage());
        }
    }

    private void checkIsCarNameAlreadyExist(String carName, HashSet<String> carSet) {
        if (carSet.contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_ALREADY_EXIST.getMessage());
        }
    }
}
