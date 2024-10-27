package racingcar.model;

import static racingcar.message.ErrorMessages.TRY_COUNT_NOT_VALID_NUMBER;

import racingcar.exception.InvalidInputException;

public class TryCount {
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
    }

    private void validatIntegerNumber(String count) {
        if (!count.matches("^\\d+$")) {
            throw new InvalidInputException(TRY_COUNT_NOT_VALID_NUMBER);
        }
    }
}
