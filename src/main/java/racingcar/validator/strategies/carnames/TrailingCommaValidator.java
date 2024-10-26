package racingcar.validator.strategies.carnames;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class TrailingCommaValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carNames) {
        if (carNames.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.TRAILING_COMMA.getMessage());
        }
    }

}
