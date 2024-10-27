package racingcar;

import static racingcar.RacingConstants.MIN_NUMBER_TO_MOVE;

public class NumberValidator {
    public boolean isAboveLowerBound(int number) {
        return number >= MIN_NUMBER_TO_MOVE;
    }
}
