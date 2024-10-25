package racingcar.validator.strategies.carnames;

import java.util.List;
import racingcar.constants.RacingGameConstants;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class MinimumCarCountValidator implements ValidationStrategy<List<String>> {
    @Override
    public void validate(List<String> names) {
        if (names.size() < RacingGameConstants.MINIMUM_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CARS.getMessage());
        }
    }

}
