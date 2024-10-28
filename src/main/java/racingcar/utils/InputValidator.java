package racingcar.utils;


import static racingcar.exception.ErrorMessages.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputValidator {

    private static final String NAME_PATTERN = "^[a-zA-Z0-9]+(,[a-zA-Z0-9]+)*$";

    private InputValidator() {
    }

    public static void nameValidator(String input) {
        if (!input.matches(NAME_PATTERN)) {
            throw new IllegalArgumentException(INVALID_SEPARATOR_ERROR);
        }

        List<String> names = new ArrayList<>(Arrays.asList(input.split(",")));

        if (names.size() == 1) {
            throw new IllegalArgumentException(SINGLE_CAR_PARTICIPATION_ERROR);
        }

        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException(NAME_LENGTH_ERROR);
            }
        }
    }

    public static void numberValidator(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_ERROR);
        }

        if (number <= 0) {
            throw new IllegalArgumentException(NON_POSITIVE_NUMBER_ERROR);
        }
    }
}
