package racingcar.validator.strategies.carnames;

import java.util.List;
import racingcar.constants.RacingGameConstants;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class MinimumNumberOfCarsValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> names) {
        checkForMinimumCount(names);
    }

    private void checkForMinimumCount(List<String> names) {
        if (names.size() < RacingGameConstants.MINIMUM_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CARS.getMessage());
        }
    }

}
