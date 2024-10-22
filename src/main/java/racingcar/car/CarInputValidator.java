package racingcar.car;

import racingcar.constant.ErrorMessage;

import java.util.HashSet;

public class CarInputValidator {
    public void checkIsCarNameValid(String carName, HashSet<String> carsToCheckDuplicate) {
        checkIsEmpty(carName);
        checkLength(carName);
        checkIsAlreadyExist(carName, carsToCheckDuplicate);
    }

    public void checkIsAllInputEmpty(String carInput) {
        if (carInput.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_INPUT_EMPTY.getMessage());
        }
    }

    private void checkLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_TO_LONG.getMessage() + ": " + carName);
        }
    }

    private void checkIsEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_EMPTY.getMessage() + ": " + carName);
        }
    }

    private void checkIsAlreadyExist(String carName, HashSet<String> carsToCheckDuplicate) {
        if (carsToCheckDuplicate.contains(carName)) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_IS_CAR_NAME_ALREADY_EXIST.getMessage() + ": " + carName);
        }
    }
}
