package racingcar.validator;

import static racingcar.exception.InputCarNamesExceptionMessage.BLANK_CAR_NAME;
import static racingcar.exception.InputCarNamesExceptionMessage.DUPLICATED_CAR_NAME;
import static racingcar.exception.InputCarNamesExceptionMessage.INVALID_CAR_NAME;

import java.util.HashSet;

public class InputCarNamesValidator {
    private HashSet<String> validCarNames = new HashSet<>();

    public boolean isCarNameLengthValid(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException(INVALID_CAR_NAME.toString());
        }
        return true;
    }

    public boolean isNotDuplicateCarName(String carName) {
        if (validCarNames.contains(carName)) {
            throw new IllegalArgumentException(DUPLICATED_CAR_NAME.toString());
        }
        validCarNames.add(carName);
        return true;
    }

    public boolean isNotCarNameEmpty(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.toString());
        }
        return true;
    }
}
