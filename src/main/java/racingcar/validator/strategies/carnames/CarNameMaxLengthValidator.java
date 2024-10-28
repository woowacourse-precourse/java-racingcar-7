package racingcar.validator.strategies.carnames;

import java.util.List;
import racingcar.constants.RacingGameConstants;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

/**
 * 자동차 이름이 5자를 초과하는지 검증
 */
public class CarNameMaxLengthValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> carNames) {
        for (String name : carNames) {
            validateMaxLength(name);
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > RacingGameConstants.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
        }
    }

}
