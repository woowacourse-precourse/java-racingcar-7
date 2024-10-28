package racingcar.validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.model.Car;

public class CarNameValidator {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String VALID_NAME_PATTERN = "^[a-z]+$";

    public static void length(List<Car> participants) {
        for (Car car : participants) {
            if (car.getName().length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException(CarErrorMessages.LENGTH_ERROR_MESSAGE + car.getName());
            }
        }
    }

    public static void duplicateNames(List<Car> participants) {
        Set<String> uniqueNames = new HashSet<>();
        for (Car car : participants) {
            if (!uniqueNames.add(car.getName())) {
                throw new IllegalArgumentException(CarErrorMessages.DUPLICATE_NAME_ERROR_MESSAGE + car.getName());
            }
        }
    }

    public static void emptyOrNullNames(List<Car> participants) {
        for (Car car : participants) {
            if (car.getName() == null || car.getName().trim().isEmpty()) {
                throw new IllegalArgumentException(CarErrorMessages.EMPTY_OR_NULL_NAME_ERROR_MESSAGE);
            }
        }
    }

    public static void Characters(String name) {
        String trimmedName = name.trim();
        if (!trimmedName.matches(VALID_NAME_PATTERN)) {
            throw new IllegalArgumentException(CarErrorMessages.INVALID_CHARACTER_ERROR_MESSAGE + name);
        }
    }

    public static void Spaces(String name) {
        if (name.length() != name.trim().length()) {
            throw new IllegalArgumentException(CarErrorMessages.LEADING_TRAILING_SPACE_ERROR_MESSAGE + name + "'");
        }
    }

    public static void commaEnding(String input) {
        if (input.endsWith(",")) {
            throw new IllegalArgumentException(CarErrorMessages.COMMA_ENDING_ERROR_MESSAGE);
        }
    }
}
