package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {
    private static final Validator instance = new Validator();

    private Validator() {}

    public static Validator getInstance() {
        return instance;
    }

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

    public void validateDuplicateName(List<String> carNamesList) {
        Set<String> carNamesSet = new HashSet<>(carNamesList);
        if (carNamesList.size() != carNamesSet.size()) {
            throw new IllegalArgumentException(Constants.DUPLICATE_CAR_NAME_ERROR_MESSAGE);
        }
    }

    public void validateContainSpaceName(List<String> carNamesList) {
        for (String carName: carNamesList) {
            if (carName.contains(" ")) {
                throw new IllegalArgumentException(Constants.CAR_NAME_CONTAIN_SPACE_ERROR_MESSAGE);
            }
        }
    }

    public void validateNameCharacters(List<String> carNamesList) {
        for (String carName: carNamesList) {
            if (carName.matches(Constants.CAR_NAME_REGEX)) {
                throw new IllegalArgumentException(Constants.CAR_NAME_CHARACTER_ERROR_MESSAGE);
            }
        }
    }

    public void validateCountContainsSpace(String count) {
        if (count.contains(" ")) {
            throw new IllegalArgumentException(Constants.COUNT_CONTAIN_SPACE_ERROR_MESSAGE);
        }
    }

    public int validateCountNonInteger(String count) {
        int countInt;
        try {
            countInt = Integer.parseInt(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.COUNT_NON_NUMBER_ERROR_MESSAGE);
        }
        return countInt;
    }

    public void validateCountPositiveIntegerAboveOne(int count) {
        if (count < 1) {
            throw new IllegalArgumentException(Constants.COUNT_ZERO_LESS_INTEGER_ERROR_MESSAGE);
        }
    }
}
