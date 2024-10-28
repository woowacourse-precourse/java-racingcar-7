package racingcar.controller.validator;

import static racingcar.exception.ErrorBase.ROUNDS_COUNT_INVALID;
import static racingcar.exception.ErrorBase.ROUNDS_MUST_BE_NUMBER;


public class ValidateRound extends Validator<Integer>{
    public static final int MAX_ROUNDS = 1000;

    @Override
    protected Integer parseInput(String input) {
        try {
            return Integer.parseInt(input);
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException(ROUNDS_MUST_BE_NUMBER.getMessage());
        }
    }

    @Override
    protected void validateRange(Integer round) {
        if (round <= 0 || round > MAX_ROUNDS) {
            throw new IllegalArgumentException(ROUNDS_COUNT_INVALID.getMessage());
        }
    }
}
