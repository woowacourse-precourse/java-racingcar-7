package racingcar.ui.validator;

import java.util.List;

public class InputValidator {

    private static final int MAXIMUM_CAR_SIZE = 100;
    private static final int MINIMUM_ROUND = 1;
    private static final int MAXIMUM_ROUND = 500;

    public static void validateCarNames(List<String> carNames) {
        validateCarNamesSize(carNames);
        validateNoWhitespace(carNames);
    }

    private static void validateCarNamesSize(List<String> carNames) {
        if (carNames.isEmpty() || carNames.size() > MAXIMUM_CAR_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateNoWhitespace(List<String> carNames) {
        if (containsWhitespace(carNames)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean containsWhitespace(List<String> splitNames) {
        return splitNames.stream()
                .anyMatch(name -> name.length() != name.trim().length());
    }

    public static void validatePositiveNumber(int finalRound) {
        if (finalRound < MINIMUM_ROUND || finalRound > MAXIMUM_ROUND) {
            throw new IllegalArgumentException();
        }
    }

}
