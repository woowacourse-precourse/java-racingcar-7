package racingcar;

import static racingcar.ExceptionMessage.ERROR_CAR_NAME_DUPLICATE;
import static racingcar.ExceptionMessage.ERROR_CAR_NAME_EMPTY;
import static racingcar.ExceptionMessage.ERROR_CAR_NAME_LENGTH;
import static racingcar.ExceptionMessage.ERROR_CAR_NAME_NOT_EXIST;
import static racingcar.ExceptionMessage.ERROR_TRY_COUNT_NOT_NATURAL_NUMBER;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    static void validateCarNames(String carNames) {
        checkNameExist(carNames);
        List<String> carNameList = new ArrayList<>();
        for (String carName : carNames.split(",", -1)) {
            String stripCarName = carName.strip();
            checkConditionForName(stripCarName, carNameList);
            carNameList.add(stripCarName);
        }
    }

    static void checkConditionForName(String carName, List<String> carNameList) {
        checkEmptyName(carName);
        checkCarNameLength(carName);
        checkDuplicateName(carName, carNameList);
    }

    static void checkDuplicateName(String carName, List<String> carNameList) {
        if (carNameList.contains(carName)) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_DUPLICATE);
        }
    }

    static void checkNameExist(String carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_NOT_EXIST);
        }
        String[] splitCarNames = carNames.split(",");
        if (splitCarNames.length == 0) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_NOT_EXIST);
        }
    }

    static void checkEmptyName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_EMPTY);
        }
    }

    static void checkCarNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(ERROR_CAR_NAME_LENGTH);
        }
    }

    static void validateTryCount(String tryCount) {
        try {
            int tryCountNum = Integer.parseInt(tryCount);
            checkNotPositiveValue(tryCountNum);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_NOT_NATURAL_NUMBER);
        }
    }

    static void checkNotPositiveValue(int tryCountNum) {
        if (tryCountNum <= 0) {
            throw new IllegalArgumentException(ERROR_TRY_COUNT_NOT_NATURAL_NUMBER);
        }
    }
}
