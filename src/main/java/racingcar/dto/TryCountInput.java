package racingcar.dto;

import racingcar.exception.ErrorMessage;
import racingcar.exception.RacingCarGameException;

public record TryCountInput(
        String tryCount
) {
    public TryCountInput {
        validateTryCountNotNull(tryCount);
        validateTryCountNotEmpty(tryCount);
    }

    private void validateTryCountNotNull(String tryCount) {
        if (tryCount == null) {
            throw RacingCarGameException.from(ErrorMessage.NULL_INPUT_ERROR);
        }
    }

    private void validateTryCountNotEmpty(String tryCount) {
        if (tryCount.isEmpty()) {
            throw RacingCarGameException.from(ErrorMessage.EMPTY_INPUT_ERROR);
        }
    }
}