package racingcar.validator.strategies.carnames;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

/**
 * 단일 자동차 이름이 빈 값이 아닌지 검증
 */
public class CarNameNotEmptyValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carName) {
        validateNotNull(carName);
        validateNotBlank(carName);
    }

    private void validateNotNull(String carName) {
        if (carName == null) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

    private void validateNotBlank(String carName) {
        if (carName.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

}
