package racingcar.validator.strategies.trycount;

import racingcar.utils.TryCountParser;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class TryCountPositiveIntegerValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String value) {
        int count = TryCountParser.parseToInt(value);
        validatePositive(count);
    }

    private void validatePositive(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_TRY_COUNT.getMessage());
        }
    }

}
