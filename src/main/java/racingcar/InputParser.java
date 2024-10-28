package racingcar;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputParser {
    public static List<String> parseCarNames(String input) {
        validateInput(input);
        List<String> carNames = Arrays.asList(input.split(",", -1));
        validateCarNames(carNames);
        return carNames;
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CAR_NAMES.getMessage());
        }
        Set<String> uniqueCarNames = new HashSet<>();
        for (String carName : carNames) {
            if (carName.isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.EMPTY_CAR_NAMES.getMessage());
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_CAR_NAME_LENGTH.getMessage());
            }
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException(ErrorMessages.DUPLICATE_CAR_NAMES.getMessage());
            }
        }
    }

    private static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessages.EMPTY_CAR_NAMES.getMessage());
        }
        if (input.contains(" ")) {
            throw new IllegalArgumentException(ErrorMessages.WHITE_SPACE_INPUT.getMessage());
        }
    }
}
