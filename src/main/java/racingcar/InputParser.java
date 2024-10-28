package racingcar;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public static List<String> parseCarNames(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CAR_NAMES.getMessage());
        }
        List<String> carNames = Arrays.asList(input.split(","));
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CAR_NAMES.getMessage());
        }
    }
}
