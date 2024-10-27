package racingcar.util;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
