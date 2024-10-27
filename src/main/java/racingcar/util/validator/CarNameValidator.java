package racingcar.util.validator;

import java.util.Arrays;
import java.util.List;
import racingcar.util.ExceptionMessage;

public class CarNameValidator extends Validator {
    private static final int MIN_CARS_COUNT = 2;
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String input) throws IllegalArgumentException {
        List<String> carNames = Arrays.asList(removeSpace(input).split(","));
        validateNumberOfCars(carNames);
        for (String carName : carNames) {
            validateCarNameLength(carName);
        }
    }

    private static void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CAR_NAME_LENGTH.getMessage());
        }
    }

    private static void validateNumberOfCars(List<String> carNames) {
        if (carNames.size() < MIN_CARS_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_CARS_COUNT.getMessage());
        }
    }
}