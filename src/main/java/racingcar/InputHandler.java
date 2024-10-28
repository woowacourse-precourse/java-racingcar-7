package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputHandler {
    private static final String NAME_DELIMITER = ",";

    public List<String> getNames(String input) {
        List<String> names = new ArrayList<>(Arrays.asList(input.split(NAME_DELIMITER)));
        validateName(names);
        return names;
    }

    public int getCount(String input) {
        validateCount(input);
        return Integer.parseInt(input);
    }

    private void validateNotEmpty(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateName(List<String> names) {
        for (String name : names) {
            validateNotEmpty(name);
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateCount(String input) {
        validateNotEmpty(input);
        if (!input.matches("\\d+")) {
            throw new IllegalArgumentException();
        }

        try {
            int count = Integer.parseInt(input);
            if (count < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
