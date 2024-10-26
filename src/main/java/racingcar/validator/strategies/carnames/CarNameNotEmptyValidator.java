package racingcar.validator.strategies.carnames;

import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

/**
 * 단일 자동차 이름이 빈 값이 아닌지 검증하는 클래스
 */
public class CarNameNotEmptyValidator implements ValidationStrategy<String> {

    @Override
    public void validate(String carName) {
        validateNotEmptyCarName(carName);
    }

    private void validateNotEmptyCarName(String carName) {
        if (carName == null || carName.trim().isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_NAMES.getMessage());
        }
    }

}
