package racingcar.validator;


import static racingcar.validator.ErrorMessages.INVALID_ROUND_MINIMUM;
import static racingcar.validator.ErrorMessages.INVALID_ROUND_NOT_NUMBER;
import static racingcar.validator.ErrorMessages.INVALID_ROUND_OUT_OF_RANGE;

import racingcar.validator.exception.InvalidRoundException;

public class RoundValidator implements Validator<String> {

    @Override
    public void validate(String roundInput) {
        validateIsNumber(roundInput);
        int roundCount = validateWithinIntRange(roundInput);
        validateGreaterThanZero(roundCount);
    }

    private void validateIsNumber(String roundInput) {
        if (!roundInput.matches("-?\\d+")) {
            throw new InvalidRoundException(INVALID_ROUND_NOT_NUMBER.getMessage());
        }
    }

    private int validateWithinIntRange(String roundInput) {
        try {
            return Integer.parseInt(roundInput);
        } catch (NumberFormatException e) {
            throw new InvalidRoundException(INVALID_ROUND_OUT_OF_RANGE.getMessage());
        }
    }

    private void validateGreaterThanZero(int roundCount) {
        if (roundCount < 1) {
            throw new InvalidRoundException(INVALID_ROUND_MINIMUM.getMessage());
        }
    }
}