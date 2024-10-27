package racingcar.model;

import static racingcar.message.ErrorMessages.TRY_COUNT_NOT_VALID_NUMBER;

import racingcar.exception.InvalidInputException;

public class TryCount {
    private static final int MAX_TRY_COUNT = 1000;

    private final int tryCount;

    public TryCount(String count) {
        validate(count);
        this.tryCount = convertStringToInt(count);
    }

    private int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public boolean isNotSame(int tryCount) {
        return this.tryCount != tryCount;
    }

    private void validate(String count) {
        validatIntegerNumber(count);
        validateValidNumber(count);
    }

    private void validatIntegerNumber(String count) {
        if (!count.matches("^\\d+$")) {
            throw new InvalidInputException(TRY_COUNT_NOT_VALID_NUMBER);
        }
    }

    private void validateValidNumber(String count) {
        long countLong= Long.parseLong(count);
        if (countLong < 0 || countLong > MAX_TRY_COUNT) {
            throw new InvalidInputException(TRY_COUNT_NOT_VALID_NUMBER);
        }
    }
}
