package racingcar;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    private static final int MAX_CAR_NAME_COUNT = 100;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MAX_ASCII_CODE = 127;

    private static final String ERROR_NULL_INPUT = "자동차 이름은 null이어서는 안 됩니다.";
    private static final String ERROR_EMPTY_NAME = "자동차 이름은 1자 이상이어야 합니다.";
    private static final String ERROR_TOO_MANY_CARS = "자동차 이름은 100개 이하로 입력되어야 합니다.";
    private static final String ERROR_NAME_TOO_LONG = "자동차 이름은 5자를 초과할 수 없습니다.";
    private static final String ERROR_NON_ASCII = "자동차 이름은 아스키 코드여야 합니다.";
    private static final String ERROR_BLANK_NAME = "자동차 이름은 공백 문자로만 이루어져 있어서는 안 됩니다.";
    private static final String ERROR_DUPLICATE_NAMES = "자동차 이름이 중복되어서는 안 됩니다.";

    private static final int MIN_COUNT = 1;
    private static final int MAX_COUNT = 100;

    private static final String ERROR_NOT_INTEGER = "시도 횟수는 정수여야 합니다.";
    private static final String ERROR_NEGATIVE_OR_ZERO = "시도 횟수는 양수여야 합니다.";
    private static final String ERROR_TOO_HIGH = "시도 횟수는 100이하여야 합니다.";

    public String[] validateCarNames(String inputCarNames) {
        checkNullInput(inputCarNames);
        checkEndsWithComma(inputCarNames);

        String[] carNames = inputCarNames.split(",");
        checkCarNameCount(carNames);
        validateEachCarName(carNames);
        checkDuplicateNames(carNames);
        return carNames;
    }

    public int validateCount(String inputCount) {
        int count = parse(inputCount);
        checkRange(count);
        return count;
    }

    private void checkNullInput(String inputCarNames) {
        if (inputCarNames == null) {
            throw new IllegalArgumentException(ERROR_NULL_INPUT);
        }
    }

    private void checkEndsWithComma(String inputCarNames) {
        if (inputCarNames.endsWith(",")) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    private void checkCarNameCount(String[] carNames) {
        if (carNames.length > MAX_CAR_NAME_COUNT) {
            throw new IllegalArgumentException(ERROR_TOO_MANY_CARS);
        }
    }

    private void validateEachCarName(String[] carNames) {
        for (String carName : carNames) {
            checkNameLength(carName);
            checkEmptyName(carName);
            checkAsciiCode(carName);
            checkNotBlank(carName);
        }
    }

    private void checkNameLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_NAME_TOO_LONG);
        }
    }

    private void checkEmptyName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_NAME);
        }
    }

    private void checkAsciiCode(String carName) {
        if (isNotAsciiCode(carName)) {
            throw new IllegalArgumentException(ERROR_NON_ASCII);
        }
    }

    private void checkNotBlank(String carName) {
        if (carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
    }

    private void checkDuplicateNames(String[] carNames) {
        if (isSameNameContained(carNames)) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAMES);
        }
    }


    private boolean isNotAsciiCode(String carName) {
        char[] chars = carName.toCharArray();
        for(char c : chars) {
            if (c > MAX_ASCII_CODE) {
                return true;
            }
        }
        return false;
    }

    private boolean isSameNameContained(String[] carNames) {
        Set<String> carNameCheckSet = new HashSet<>();
        for(String carName : carNames) {
            if(!carNameCheckSet.add(carName)) {
                return true;
            }
        }
        return false;
    }

    private int parse(String inputCount) {
        try {
            return Integer.parseInt(inputCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_INTEGER);
        }
    }

    private void checkRange(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_NEGATIVE_OR_ZERO);
        }
        if (count > MAX_COUNT) {
            throw new IllegalArgumentException(ERROR_TOO_HIGH);
        }
    }
}
