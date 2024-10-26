package racingcar.validator;

import java.util.HashSet;

public class CarNameValidator implements Validator {

    private static final String ERROR_EMPTY_INPUT = "Input a name that contains at least one character.";
    private static final String ERROR_DUPLICATE_NAME = "Input a name that is not already in use.";
    private static final String ERROR_BLANK_NAME = "Input a name that is not composed only of whitespace.";
    private static final String ERROR_LONG_NAME = "Input a name with 5 characters of fewer.";

    private static final int MAX_NAME_LENGTH = 5;
    private static final String INPUT_DELIMITER = ",";

    @Override
    public void validate(String input) {
        String[] carNames = input.split(INPUT_DELIMITER);
        checkEmpty(carNames);
        checkDuplicate(carNames);
        validateIndividualNames(carNames);
    }

    private void checkEmpty(String[] carNames) {
        if (carNames.length == 0) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }

    private void checkDuplicate(String[] carNames) {
        HashSet<String> carNamesSet = new HashSet<>();
        for (String carName : carNames) {
            if (!carNamesSet.add(carName)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
            }
        }
    }

    private void validateIndividualNames(String[] carNames) {
        for (String carName : carNames) {
            checkBlank(carName);
            checkLength(carName);
        }
    }

    private void checkBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_NAME);
        }
    }

    private void checkLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_LONG_NAME);
        }
    }
}
