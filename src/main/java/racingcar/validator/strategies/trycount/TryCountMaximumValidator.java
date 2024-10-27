package racingcar.validator.strategies.trycount;

import racingcar.constants.RacingGameConstants;
import racingcar.utils.TryCountParser;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class TryCountMaximumValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String value) {
        int count = TryCountParser.parseToInt(value);
        validateWithinMax(count);
    }

    private void validateWithinMax(int count) {
        if (count > RacingGameConstants.MAX_TRY_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.EXCEEDS_MAX_TRY_COUNT.getMessage());
        }
    }

}
