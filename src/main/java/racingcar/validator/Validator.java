package racingcar.validator;

import racingcar.Constants;

import java.util.ArrayList;

public class Validator {
    public void isRightNamesString(String namesString) {
        if (!ErrorMessage.NAME_STRING_PATTERN.matcher(namesString).matches()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_WRONG_ERROR);
        }
    }

    public void isRightNameSize(ArrayList<String> names) {
        if (names.stream().anyMatch(name -> name.isEmpty() || name.length() > ErrorMessage.NAME_SIZE)) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_SIZE_ERROR);
        }
    }

    public void isNotDuplicate(ArrayList<String> names) {
        if (names.size() != names.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.CAR_NAME_DUPLICATE_ERROR);
        }
    }

    public void isRightRoundNumber(String roundNumString) {
        if (!ErrorMessage.ROUND_NUMBER_PATTERN.matcher(roundNumString).matches()) {
            throw new IllegalArgumentException(ErrorMessage.ROUND_NUMBER_WRONG_ERROR);
        }
    }
}
