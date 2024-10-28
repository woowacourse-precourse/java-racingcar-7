package racingcar.validator.strategies.carnames;

import java.util.List;
import racingcar.constants.RacingGameConstants;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;


/**
 * 자동차 이름 목록의 최소 개수를 검증
 */
public class CarMinimumCountValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> names) {
        validateMinimumCount(names);
    }

    private void validateMinimumCount(List<String> names) {
        if (names.size() < RacingGameConstants.MINIMUM_CAR_COUNT.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.MINIMUM_CARS.getMessage());
        }
    }

}
