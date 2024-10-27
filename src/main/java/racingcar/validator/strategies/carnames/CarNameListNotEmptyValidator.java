package racingcar.validator.strategies.carnames;

import java.util.List;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

/**
 * 자동차 이름 목록에 빈 값이 없는지 검증
 */
public class CarNameListNotEmptyValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> carNames) {
        validateListNotNull(carNames);
        validateNonEmptyNames(carNames);
    }

    private void validateListNotNull(List<String> carNames) {
        if (carNames == null) {
            throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_IN_LIST.getMessage());
        }
    }

    private void validateNonEmptyNames(List<String> carNames) {
        for (String carName : carNames) {
            if (carName == null || carName.isBlank()) {
                throw new IllegalArgumentException(ErrorMessage.EMPTY_NAME_IN_LIST.getMessage());
            }
        }
    }
}
