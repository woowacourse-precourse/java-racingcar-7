package racingcar.util.validator;

import java.util.Arrays;
import java.util.List;
import racingcar.util.Util;

public class CarNameValidator extends Validator {
    private static final int MIN_CARS_COUNT = 2;
    private static final int MAX_NAME_LENGTH = 5;

    @Override
    public void validate(String input) throws IllegalArgumentException {
        InputCommaValidator.validateFormat(input);
        List<String> carNames = Arrays.asList(Util.removeSpace(input).split(","));
        validateNumberOfCars(carNames);
        validateEachCarName(carNames);
    }

    private void validateEachCarName(List<String> carNames) {
        carNames.forEach(this::validateCarNameLength);
    }

    private void validateCarNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateNumberOfCars(List<String> carNames) {
        if (carNames.size() < MIN_CARS_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}