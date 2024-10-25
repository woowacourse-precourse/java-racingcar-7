package racingcar.validator.strategies.trycount;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class NotNullOrEmptyTryCountValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String value) {
        ensureNotNullOrEmpty(value);
    }

    private void ensureNotNullOrEmpty(String value) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_TRY_COUNT.getMessage());
        }
    }

}
