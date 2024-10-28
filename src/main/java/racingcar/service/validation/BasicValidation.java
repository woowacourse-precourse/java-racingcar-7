package racingcar.service.validation;

import racingcar.exception.ErrorMessage;

public class BasicValidation {

    public static void validateEmpty(final String input) {
        if (input.isEmpty()){
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_EMPTY_OR_NULL.toString());
        }
    }

    public static void validateNull(final String input) {
        if (input == null) {
            throw new IllegalArgumentException(ErrorMessage.ERROR_INPUT_EMPTY_OR_NULL.toString());
        }
    }
}
