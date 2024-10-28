package racingcar;

import static racingcar.ErrorMessage.DUPLICATE_NAME;
import static racingcar.ErrorMessage.INCORRECT_TYPE_COMMA_N_NAME;
import static racingcar.ErrorMessage.INPUT_IS_EMPTY;
import static racingcar.ErrorMessage.ONLY_COMMA_HERE;
import static racingcar.ErrorMessage.OVER_5_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class ValidateCar {
    public static void inputCar(String userInput) {
        emptyInput(userInput);
        extraComma(userInput);

        Set<String> carNames = new HashSet<>();
        for (String carName : userInput.split(",", -1)) {
            String trimmedPart = carName.trim();
            emptyPart(trimmedPart);
            overNameLength(trimmedPart);
            duplicateNames(trimmedPart, carNames);
        }
    }

    private static void emptyInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }
    }

    private static void extraComma(String userInput) {
        String[] splitUserInputTemp = userInput.split(",");
        if (splitUserInputTemp.length == 0) {
            throw new IllegalArgumentException(ONLY_COMMA_HERE);
        }
    }

    private static void emptyPart(String trimmedPart) {
        if (trimmedPart.isEmpty()) {
            throw new IllegalArgumentException(INCORRECT_TYPE_COMMA_N_NAME);
        }
    }

    private static void overNameLength(String trimmedPart) {
        if (trimmedPart.length() > 5) {
            throw new IllegalArgumentException(OVER_5_LENGTH);
        }
    }

    private static void duplicateNames(String carName, Set<String> carNames) {
        if (!carNames.add(carName)) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }
}
