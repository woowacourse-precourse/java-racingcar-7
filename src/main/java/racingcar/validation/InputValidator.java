package racingcar.validation;

import racingcar.exception.ErrorMessage;

public class InputValidator {

    private static final int MAX_CAR_NAME_LENGTH = 5;

    private InputValidator() {}

    public static void validateCarNames(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if(name.length() < MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_NAME_LENGTH.getMessage());
            }
        }
    }


}
