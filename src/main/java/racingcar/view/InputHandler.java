package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class InputHandler {
    private static final String DELIMITER = ",";

    public void checkEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> validateUniqueNames(final String input) {
        final List<Car> uniqueCars = new ArrayList<>();

        final String[] parsedNames = input.split(DELIMITER);
        for (final String name : parsedNames) {
            final Car car = new Car(name);
            if (uniqueCars.contains(car)) {
                throw new IllegalArgumentException();
            }
            uniqueCars.add(car);
        }
        return uniqueCars;
    }

    public int validateNumber(final String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    public void checkMinimumOne(final int attemptCount) {
        if (attemptCount < 1) {
            throw new IllegalArgumentException();
        }
    }
}
