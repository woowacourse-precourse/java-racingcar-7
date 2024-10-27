package racingcar.validation;

import racingcar.constant.ExceptionMessage;

public class InputValidator {

    public void validateInputIsEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.INPUT_EMPTY);
        }
    }

    public void validateCarName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_EMPTY);
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException(ExceptionMessage.NAME_LENGTH_EXCEED);
        }
    }

    public void validateTryCount(String tryCount) {
        int tryCountNum;
        try {
            tryCountNum = Integer.parseInt(tryCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_COUNT_NOT_INTEGER);
        }

        if (tryCountNum <= 0) {
            throw new IllegalArgumentException(ExceptionMessage.TRY_COUNT_MUST_NATURAL_NUMBER);
        }
    }
}
