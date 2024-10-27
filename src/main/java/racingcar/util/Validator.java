package racingcar.util;

import java.util.List;

public class Validator {
    public void validateEmptyString(String input) {
        if (input == null || input.equals("")) {
            throw new IllegalArgumentException(Constants.EMPTY_INPUT_ERROR_MESSAGE);
        }
    }

    public void validateStringLength(List<String> carNamesList) {
        for (String splitInput: carNamesList) {
            if (splitInput.length() >= 6) {
                throw new IllegalArgumentException(Constants.CAR_NAME_LENGTH_ERROR_MESSAGE);
            }
        }
    }
}
