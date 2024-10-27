package racingcar.validator;

import static racingcar.config.GameConstant.CAR_NAME_UPPER_BOUND;
import static racingcar.config.GameErrorMessage.DUPLICATE_CAR_NAME_MESSAGE;
import static racingcar.config.GameErrorMessage.EMPTY_NAME_MESSAGE;
import static racingcar.config.GameErrorMessage.INVALID_NAME_FORMAT_MESSAGE;
import static racingcar.config.GameErrorMessage.LENGTH_EXCEED_MESSAGE;

import java.util.HashSet;
import java.util.Set;

public class CarNameValidator {
    private CarNameValidator() {
        throw new IllegalStateException("Validator Class");
    }

    public static void validateCarName(String[] carNames) {
        validateEmptyName(carNames);
        validateDuplicateCarName(carNames);
        validateNameFormat(carNames);
        validateAllowedLength(carNames);
    }

    private static void validateEmptyName(String[] carNames) {
        for (String carName : carNames) {
            String deleteWhiteSpaceString = carName.replace(" ", "");
            if (deleteWhiteSpaceString.isEmpty()) {
                throw new IllegalArgumentException(EMPTY_NAME_MESSAGE);
            }
        }
    }

    private static void validateDuplicateCarName(String[] carNames) {
        Set<String> carNameSet = new HashSet<>();
        for (String carName : carNames) {
            if (carNameSet.contains(carName)) {
                throw new IllegalArgumentException(DUPLICATE_CAR_NAME_MESSAGE);
            }
            carNameSet.add(carName);
        }
    }

    private static void validateNameFormat(String[] carNames) {
        for (String carName : carNames) {
            if (carName.startsWith(" ") || carName.endsWith(" ")) {
                throw new IllegalArgumentException(INVALID_NAME_FORMAT_MESSAGE);
            }
        }
    }

    private static void validateAllowedLength(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > CAR_NAME_UPPER_BOUND) {
                throw new IllegalArgumentException(LENGTH_EXCEED_MESSAGE);
            }
        }
    }
}
