package racingcar.validator;

import racingcar.enums.ErrorMessage;

public class CarNameInputValidator {

    private CarNameInputValidator() {
    }

    public static void validateCarNames(String carNames) {
        validateBlank(carNames);
    }

    private static void validateBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.BLANK_INPUT_NOT_ALLOWED.getMessage());
        }
    }
}
