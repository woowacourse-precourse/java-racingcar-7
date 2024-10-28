package racingcar.validator;

import racingcar.exception.InvalidAttemptNumber;

public class RoundValidator {
    public static void validate(int value) {
        if (value < 1) {
            throw new InvalidAttemptNumber();
        }
    }
}
