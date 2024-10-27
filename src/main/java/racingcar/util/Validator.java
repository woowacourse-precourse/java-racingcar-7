package racingcar.util;

public class Validator {
    public void validateEmptyString(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE);
        }
    }
}
