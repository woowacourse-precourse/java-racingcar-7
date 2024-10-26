package racingcar.validator.strategies.carnames;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class CarNameTrailingCommaValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carName) {
        validateNoTrailingComma(carName);
    }

    private void validateNoTrailingComma(String carName) {
        if (carName.endsWith(",")) {
            throw new IllegalArgumentException(ErrorMessage.TRAILING_COMMA.getMessage());
        }
    }

}
