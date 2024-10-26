package racingcar;

import static racingcar.ExceptionMessage.*;

public class InputValidator {
    static final int MIN_CAR_NAME_LENGTH = 1;
    static final int MAX_CAR_NAME_LENGTH = 5;

    public static String validateCarName(String input) {
        if (input == null) {
            throw new IllegalArgumentException(NULL_CAR_NAME.getMessage());
        }

        input = input.strip();

        if (input.isBlank()) {
            throw new IllegalArgumentException(BLANK_CAR_NAME.getMessage());
        }

        if (input.length() < MIN_CAR_NAME_LENGTH || input.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(INVALID_LENGTH_RANGE_CAR_NAME.getMessage(),
                            MIN_CAR_NAME_LENGTH, MAX_CAR_NAME_LENGTH, input));
        }

        return input;
    }
}
