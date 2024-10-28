package racingcar.validator.strategies.trycount;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class TryCountNotNullOrEmptyValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String value) {
        validateNotNullOrEmpty(value);
    }


    private void validateNotNullOrEmpty(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_TRY_COUNT.getMessage());
        }
    }

}
