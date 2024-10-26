package racingcar.validator.strategies.carnames;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class CarNameNotEmptyValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carNames) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

}
