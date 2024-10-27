package view.validation;

import view.message.ErrorMessage;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private static final String CARS_REGEX = "^(\\s*[a-zA-Z]+\\s*)(,\\s*[a-zA-Z]+\\s*)*$";
    private static final String COUNT_REGEX = "^[0-9]+$";

    private static final int CAR_NAME_MAX_LENGTH = 5;
    private static final String CAR_DELIMITER = ",";

    public static void validateCars(String cars) throws IllegalArgumentException {
        if (cars == null || cars.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MESSAGE.getMessage());
        }
        if (!cars.matches(CARS_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.SHAPE_MESSAGE.getMessage());
        }

        String[] carName = cars.split(CAR_DELIMITER);

        Arrays.stream(carName)
                .filter(car -> car.isEmpty() || car.length() > CAR_NAME_MAX_LENGTH)
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(ErrorMessage.CAR_NAME_LENGTH_MESSAGE.getMessage());
                });

        Set<String> duplicateCarName = new HashSet<>();
        Arrays.stream(carName)
                .filter(car -> !duplicateCarName.add(car))
                .findAny()
                .ifPresent(car -> {
                    throw new IllegalArgumentException(ErrorMessage.EXIST_CAR_NAME_MESSAGE.getMessage());
                });
    }

    public static int validateCount(String count) throws IllegalArgumentException {
        if (count == null || count.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_MESSAGE.getMessage());
        }
        if (!count.matches(COUNT_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.SHAPE_MESSAGE.getMessage());
        }

        return Integer.parseInt(count);
    }
}
