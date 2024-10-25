package racingcar.model;

import static racingcar.constant.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    public void validateCarNames(List<String> CarNames) {
        List<String> uniqueCarNames = new ArrayList<>();
        for (String carName : CarNames) {
            validateNotEmpty(carName);
            validateNoSpaces(carName);
            validateMaxLength(carName, MAX_CAR_NAME_LENGTH);
            validateNoDuplicate(carName, uniqueCarNames);
            uniqueCarNames.add(carName);
        }

        validateMinCount(uniqueCarNames, MIN_CAR_COUNT);
    }

    public void validateAttemptCount(String attemptCountInput) {
        try {
            int attemptCount = Integer.parseInt(attemptCountInput);
            validatePositiveNumber(attemptCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNotEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoSpaces(String input) {
        if (input.contains(SPACE)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMaxLength(String input, int maxLength) {
        if (input.length() > maxLength) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNoDuplicate(String input, List<String> uniqueNames) {
        if (uniqueNames.contains(input)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMinCount(List<String> names, int minCount) {
        if (names.size() < minCount) {
            throw new IllegalArgumentException();
        }
    }

    private void validatePositiveNumber(int number) {
        if (number < MIN_ATTEMPT_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
