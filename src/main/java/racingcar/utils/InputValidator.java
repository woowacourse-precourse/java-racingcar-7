package racingcar.utils;

import java.util.List;

public class InputValidator {
    private static final String DELIMITER = ",";

    public List<String> validateCarNames(String inputString) {
        List<String> carNames = List.of(inputString.split(Constant.DELIMITER));

        validateNameLength(carNames);
        validateNameEmpty(carNames);

        return carNames;
    }

    private void validateNameLength(List<String> carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(Constant.CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }

    private void validateNameEmpty(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(Constant.CAR_NAME_EMPTY_ERROR_MESSAGE);
            }
        }
    }

    private void validateNumber(String inputString) {
        if (!inputString.matches("[0-9]+")) {
            throw new IllegalArgumentException(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validatePositiveNumber(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }
}
