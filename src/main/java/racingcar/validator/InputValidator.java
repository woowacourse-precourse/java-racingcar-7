package racingcar.validator;

import static racingcar.constants.Constraints.CAR_NAME_REGEX;
import static racingcar.constants.Constraints.MAX_CAR_NAME_LENGTH;
import static racingcar.constants.ErrorMessages.CONTAIN_BLANK_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.NAME_DUPLICATE_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.OVER_LENGTH_ERROR_MESSAGE;
import static racingcar.constants.ErrorMessages.UNDER_LENGTH_ERROR_MESSAGE;
import static racingcar.constants.FormatConstants.BLANK;

import java.util.List;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        checkDuplicate(carNames);
        carNames.stream().forEach(carName -> {
            checkLength(carName);
            checkBlank(carName);
            checkFormat(carName);
        });
    }

    private static void checkLength(String carName) {
        if (carName.length() > MAX_CAR_NAME_LENGTH)
            throw new IllegalArgumentException(OVER_LENGTH_ERROR_MESSAGE);
        if (carName.isBlank())
            throw new IllegalArgumentException(UNDER_LENGTH_ERROR_MESSAGE);
    }

    private static void checkBlank(String carName) {
        if (carName.contains(BLANK))
            throw new IllegalArgumentException(CONTAIN_BLANK_ERROR_MESSAGE);
    }

    private static void checkFormat(String carName) {
        if (!carName.matches(CAR_NAME_REGEX))
            throw new IllegalArgumentException(CONTAIN_SPECIAL_CHARACTER_ERROR_MESSAGE);
    }

    private static void checkDuplicate(List<String> carNames) {
        long distinctCount = carNames.stream().
                map(String::toLowerCase).
                distinct().
                count();

        if (carNames.size() != distinctCount)
            throw new IllegalArgumentException(NAME_DUPLICATE_ERROR_MESSAGE);
    }
}
