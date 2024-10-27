package racingcar.model.number;

import static racingcar.model.number.RandomNumberGenerator.MAX_RANDOM_NUMBER;
import static racingcar.model.number.RandomNumberGenerator.MIN_RANDOM_NUMBER;

import racingcar.common.ErrorMessage;

public class Number {
    private static final int FORWARD_THRESHOLD = 4;
    private final int number;

    protected Number(final int number) {
        validateNumber(number);
        this.number = number;
    }

    public boolean isGreaterThanForwardThreshold() {
        return number >= FORWARD_THRESHOLD;
    }

    private void validateNumber(final int number) {
        if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException(ErrorMessage.OUT_OF_RANGE.getMessage());
        }
    }
}
