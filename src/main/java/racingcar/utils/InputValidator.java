package racingcar.utils;

import java.util.List;

public class InputValidator {

    public List<String> validateCarNames(String userInput) {
        List<String> carNames = List.of(userInput.split(Constant.DELIMITER));

        validateNameLength(carNames);
        validateNameEmpty(carNames);

        return carNames;
    }

    public int validateAttemptCount(String userInput) {
        validateNumber(userInput);

        int attemptCount = Integer.parseInt(userInput);
        validatePositiveNumber(attemptCount);

        return attemptCount;
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

    private void validateNumber(String userInput) {
        if (!userInput.matches("[0-9]+")) {
            throw new IllegalArgumentException(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }

    private void validatePositiveNumber(int attemptCount) {
        if (attemptCount <= 0) {
            throw new IllegalArgumentException(Constant.ATTEMPT_COUNT_NUMBER_ERROR_MESSAGE);
        }
    }
}
