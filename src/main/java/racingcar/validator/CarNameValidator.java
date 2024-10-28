package racingcar.validator;

import static racingcar.validator.ErrorCode.CAR_NAME_CANNOT_BE_EMPTY;
import static racingcar.validator.ErrorCode.CAR_NAME_DUPLICATE;
import static racingcar.validator.ErrorCode.CAR_NAME_TOO_LONG;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {

    public static void validate(String carNames) {
        String[] carNamesArr = carNames.trim().split(",");

        checkForEmptyNames(carNamesArr);
        checkForNameLength(carNamesArr);
        checkForDuplicateNames(carNamesArr);
    }

    private static void checkForEmptyNames(String[] carNamesArr) {
        if (Arrays.stream(carNamesArr).anyMatch(String::isBlank)) {
            throw new IllegalArgumentException(CAR_NAME_CANNOT_BE_EMPTY.getMessage());
        }
    }

    private static void checkForNameLength(String[] carNamesArr) {
        if (Arrays.stream(carNamesArr).anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException(CAR_NAME_TOO_LONG.getMessage());
        }
    }

    private static void checkForDuplicateNames(String[] carNamesArr) {
        Set<String> uniqueNames = new HashSet<>();
        if (Arrays.stream(carNamesArr).anyMatch(name -> !uniqueNames.add(name.trim()))) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE.getMessage());
        }
    }
}