package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    private static final String DELIMITER = ",";

    public void checkEmpty(final String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
    }

    public List<String> validateUniqueNames(final String input) {
        final List<String> uniqueNames = new ArrayList<>();

        final String[] parsedNames = input.split(DELIMITER);
        for (final String name : parsedNames) {
            if (uniqueNames.contains(name)) {
                throw new IllegalArgumentException();
            }
            uniqueNames.add(name);
        }
        return uniqueNames;
    }
}
