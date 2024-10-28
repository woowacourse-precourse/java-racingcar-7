package racingcar;

import static racingcar.Constants.*;

import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public void checkNull(String input) {
        if (input == null) {
            throw new IllegalArgumentException(ERROR_NULL_INPUT);
        }
    }

    public void checkEndsWithComma(String input) {
        if (input.endsWith(CAR_NAME_DELIMITER)) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    public void checkMaxSize(String[] carNames) {
        if (carNames.length > MAX_CAR_NAME_COUNT) {
            throw new IllegalArgumentException(ERROR_TOO_MANY_CARS);
        }
    }

    public void checkNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
        }
    }

    public void checkEmptyName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    public void checkAsciiCode(String carName) {
        if (isNotAsciiCode(carName)) {
            throw new IllegalArgumentException(ERROR_NON_ASCII);
        }
    }

    public void checkNotBlank(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
    }

    public void checkDuplicate(String[] carNames) {
        if (isSameNameContained(carNames)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES);
        }
    }

    public int toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER_ATTEMPTS);
        }
    }

    public void checkRange(int attempts) {
        if (attempts < MIN_ATTEMPT) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_OR_ZERO_ATTEMPTS);
        }
        if (attempts > MAX_ATTEMPT) {
            throw new IllegalArgumentException(ERROR_TOO_HIGH_ATTEMPTS);
        }
    }

    private boolean isNotAsciiCode(String carName) {
        char[] chars = carName.toCharArray();
        for (char c : chars) {
            if (c > MAX_ASCII_CODE) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameNameContained(String[] carNames) {
        Set<String> carNameCheckSet = new HashSet<>();
        for (String carName : carNames) {
            if (!carNameCheckSet.add(carName)) {
                return true;
            }
        }
        return false;
    }
}
