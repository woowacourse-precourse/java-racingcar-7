package racingcar;

import org.assertj.core.api.ThrowableAssert;

import java.util.regex.Pattern;

public class Validation {
    private static final String CAR_NAME_INPUT_PATTERN = "[a-zA-Z0-9]{1,5}";

    public String[] validateCarName(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException();
        }
        String[] carNames = input.split(",");
        for (String carName : carNames) {
            if (!Pattern.matches(CAR_NAME_INPUT_PATTERN, carName)) {
                throw new IllegalArgumentException();
            }
        }
        return carNames;
    }

    public int validateRoundLimit(String input) {
        int limit = Integer.parseInt(input);
        if (limit <= 0 || limit > 100) {
            throw new IllegalArgumentException();
        }
        return limit;
    }
}