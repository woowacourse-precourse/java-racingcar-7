package racingcar.validator.strategies.carnames;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class CarNameNotEmptyValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carName) {
        checkForEmptyCarName(carName);
    }

    private void checkForEmptyCarName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

}
