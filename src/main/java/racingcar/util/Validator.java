package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final String VALID_NAME_PATTERN = "^[a-zA-Z0-9]+$";
    private static final String PRINTABLE_PATTERN = "\\p{Print}+";

    public static void carNameValidate(List<String> carNames) {
        Set<String> uniqueCarNames = new HashSet<>();

        if (carNames.size() > 1000) {
            throw new IllegalArgumentException();
        }
        if (carNames.size() == 0){
            throw new IllegalArgumentException();
        }
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException();
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException();
            }
            if (!uniqueCarNames.add(carName)) {
                throw new IllegalArgumentException();
            }
            if (!carName.matches(VALID_NAME_PATTERN)) {
                throw new IllegalArgumentException();
            }
            if (!carName.matches(PRINTABLE_PATTERN)) {
                throw new IllegalArgumentException();
            }
        }
    }

    public static void gameRoundValidate(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException();
        }
        try {
            double number = Double.parseDouble(input);

            if (number <= 0 || number != (int) number) {
                throw new IllegalArgumentException();
            }
            if (number > 1000) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
