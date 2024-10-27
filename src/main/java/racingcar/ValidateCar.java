package racingcar;

import static racingcar.ConstantMessage.DUPLICATE_NAME;
import static racingcar.ConstantMessage.INCORRECT_TYPE_COMMA_N_NAME;
import static racingcar.ConstantMessage.INPUT_IS_EMPTY;
import static racingcar.ConstantMessage.ONLY_COMMA_HERE;
import static racingcar.ConstantMessage.OVER_5_LENGTH;

import java.util.HashSet;
import java.util.Set;

public class ValidateCar {
    public static void validateInputCar(String userInput) {
        validateEmptyInput(userInput);
        validateExtraComma(userInput);

        Set<String> carNames = new HashSet<>();
        for (String carName : userInput.split(",", -1)) {
            String trimmedPart = carName.trim();
            validateEmptyPart(trimmedPart);
            validateNameLength(trimmedPart);
            validateDuplicateNames(trimmedPart, carNames);
        }
    }

    private static void validateEmptyInput(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException(INPUT_IS_EMPTY);
        }
    }

    private static void validateExtraComma(String userInput) {
        String[] splitUserInputTemp = userInput.split(",");
        if (splitUserInputTemp.length == 0) {
            throw new IllegalArgumentException(ONLY_COMMA_HERE);
        }
    }

    private static void validateEmptyPart(String trimmedPart) {
        if (trimmedPart.isEmpty()) {
            throw new IllegalArgumentException(INCORRECT_TYPE_COMMA_N_NAME);
        }
    }

    private static void validateNameLength(String trimmedPart) {
        if (trimmedPart.length() > 5) {
            throw new IllegalArgumentException(OVER_5_LENGTH);
        }
    }

    private static void validateDuplicateNames(String carName, Set<String> carNames) {
        if (!carNames.add(carName)) {
            throw new IllegalArgumentException(DUPLICATE_NAME);
        }
    }
}
