package racingcar.validator.strategies.carnames;

import racingcar.constants.RacingGameConstants;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class NameLengthValidator implements ValidationStrategy<String> {
    @Override
    public void validate(String name) {
        if (name.length() > RacingGameConstants.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
        }
    }

}
