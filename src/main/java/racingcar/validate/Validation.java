package racingcar.validate;

import racingcar.model.ErrorType;

import java.util.HashSet;
import java.util.Set;

public class Validation {

    public void isInvalidInput(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(ErrorType.INPUT_NULL_ERROR.getMessage());
        }
    }

    public void isInvalidNameLength(String input) {
        if(input.trim().length() > 5) {
            throw new IllegalArgumentException(ErrorType.CAR_NAME_LENGTH_ERROR.getMessage());
        }
    }

    public void isInvalidGameTryCount(int count) {
        if(count < 1) {
            throw new IllegalArgumentException(ErrorType.GAME_TRY_COUNT_ERROR.getMessage());
        }
    }

    public void isDuplicateCarName(String input, Set<String> distinctCarsName) {
        if(!distinctCarsName.add(input)) {
            throw new IllegalArgumentException(ErrorType.CAR_NAME_DUPLICATE_ERROR.getMessage());
        }
    }

}
