package racingcar;

import racingcar.constant.ErrorMessage;

import java.util.HashSet;

public class CarInputValidator {
    public void checkIsCarNameValid(String carName, HashSet<String> carsToCheckDuplicate) {
        checkIsCarNameEmpty(carName);
        checkCarNameLength(carName);
        checkIsCarNameAlreadyExist(carName, carsToCheckDuplicate);
    }

    private void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_TO_LONG.getMessage() + ": " + carName);
        }
    }

    private void checkIsCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_EMPTY.getMessage() + ": " + carName);
        }
    }

    private void checkIsCarNameAlreadyExist(String carName, HashSet<String> carsToCheckDuplicate) {
        if (carsToCheckDuplicate.contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_ALREADY_EXIST.getMessage() + ": " + carName);
        }
    }
}
