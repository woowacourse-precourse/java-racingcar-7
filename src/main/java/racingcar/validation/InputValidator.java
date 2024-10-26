package racingcar.validation;

import racingcar.constants.ErrorMessages;
import racingcar.constants.ValidationConstants;

import java.util.List;

public class InputValidator {
    public static void validateCarNames(List<String> carNames) {
        for (String name : carNames) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_EMPTY_CAR_NAME);
            }
            if (name.length() > ValidationConstants.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessages.ERROR_CAR_NAME_TOO_LONG);
            }
        }
    }
}
