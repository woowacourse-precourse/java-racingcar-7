package racingcar.domain;

import java.util.*;

import static racingcar.constants.exception.ErrorMessage.INVALID_CAR_NAME_LENGTH;
import static racingcar.constants.exception.ErrorMessage.DUPLICATE_CAR_NAME_NOT_ALLOWED;

public class Car {

    private static final String CAR_NAME_DELIMITER = ",";

    private final List<String> cars;

    private Car(String input) {
        List<String> carNames = splitByComma(input);
        Validator.validateCars(carNames);
        this.cars = carNames;
    }

    public static Car from(String input) {
        return new Car(input);
    }

    public List<String> getCars() {
        return cars;
    }

    private static List<String> splitByComma(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .toList();
    }

    private static class Validator {

        private final static int MAX_CAR_NAME_LENGTH = 5;

        private static void validateCars(List<String> cars) {
            validateCarNames(cars);
            validateUniqueCarNames(cars);
        }

        private static void validateCarNames(List<String> carNames) {
            carNames.forEach(name -> {
                if (name.length() > MAX_CAR_NAME_LENGTH) {
                    throw new IllegalArgumentException(INVALID_CAR_NAME_LENGTH.getMessage());
                }
            });
        }

        private static void validateUniqueCarNames(List<String> validCarNames) {
            int validCarNameSize = validCarNames.size();
            int uniqueCarNameSize = new HashSet<>(validCarNames).size();
            if (validCarNameSize != uniqueCarNameSize) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_NOT_ALLOWED.getMessage());
            }
        }

    }

}