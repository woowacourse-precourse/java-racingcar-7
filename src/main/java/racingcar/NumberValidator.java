package racingcar;

import static racingcar.RacingConstants.FORWARD_CONDITION_LOWER_BOUND;

public class NumberValidator {
    public boolean isAboveLowerBound(int number) {
        return number >= FORWARD_CONDITION_LOWER_BOUND;
    }
}
