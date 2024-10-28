package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class InputHandler {
    private static final String DELIMITER = ",";
    private static final int MINIMUM_COUNT = 1;

    public void checkEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public List<Car> validateUniqueNames(String input) {
        final List<Car> uniqueCars = new ArrayList<>();

        final String[] parsedNames = input.split(DELIMITER);
        for (final String name : parsedNames) {
            final Car car = new Car(name, 0);
            if (uniqueCars.contains(car)) {
                throw new IllegalArgumentException();
            }
            uniqueCars.add(car);
        }
        return uniqueCars;
    }

    public int validateNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (Exception exception) {
            throw new IllegalArgumentException(exception);
        }
    }

    public void checkMinimumCount(int attemptCount) {
        if (attemptCount < MINIMUM_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
