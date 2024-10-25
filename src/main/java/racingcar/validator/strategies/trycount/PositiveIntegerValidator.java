package racingcar.validator.strategies.trycount;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class PositiveIntegerValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String value) {
        int count = parseInteger(value);
        checkIfPositive(count);
    }

    private int parseInteger(String value) {
        try {
            return Integer.parseInt(value.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

    private void checkIfPositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

}
