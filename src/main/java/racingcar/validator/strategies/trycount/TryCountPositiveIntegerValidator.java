package racingcar.validator.strategies.trycount;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class TryCountPositiveIntegerValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String value) {
        int count = parseTryCountToInteger(value);
        validatePositive(count);
    }

    private int parseTryCountToInteger(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

}
