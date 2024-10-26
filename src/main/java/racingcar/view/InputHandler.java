package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private static final String DELIMITER = ",";
    private static final int MINIMUM_COUNT = 1;

    public void checkEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> validateUniqueNames(String input) {
        final List<String> uniqueCars = new ArrayList<>();

        final String[] parsedNames = input.split(DELIMITER);
        for (final String name : parsedNames) {
            if (uniqueCars.contains(name)) {
                throw new IllegalArgumentException();
            }
            uniqueCars.add(name);
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
