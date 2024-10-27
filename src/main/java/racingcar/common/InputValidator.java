package racingcar.common;

import java.util.Arrays;

public class InputValidator {

    private static final int MIN_ATTEMPT_COUNT = 1;
    private static final int MIN_NUMBER_OF_CARS = 2;
    private static final int MAX_CAR_NAME_LENGTH = 5;

    public void validateCarNamesAndNumberOfCars(String[] carNames) {
        validateNumberOfCars(carNames);
        validateCarNames(carNames);
    }

    private void validateNumberOfCars(String[] carNames) {
        if (carNames.length < MIN_NUMBER_OF_CARS) {
            throw new IllegalArgumentException(ErrorMessage.NUMBER_OF_CAR_ERROR.getMessage());
        }
    }

    private void validateCarNames(String[] carNames) {
        Arrays.stream(carNames)
                .filter(carName -> carName.length() > MAX_CAR_NAME_LENGTH)
                .findAny()
                .ifPresent(carName -> {
                    throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_ERROR.getMessage());
                });
    }

    public int validateAttemptCount(String input) {
        try {
            int attemptCount = Integer.parseInt(input);
            if (attemptCount < MIN_ATTEMPT_COUNT) {
                throw new IllegalArgumentException(ErrorMessage.ATTEMPT_COUNT_MINIMUM_ERROR.getMessage());
            }
            return attemptCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_ERROR.getMessage());
        }
    }

}
