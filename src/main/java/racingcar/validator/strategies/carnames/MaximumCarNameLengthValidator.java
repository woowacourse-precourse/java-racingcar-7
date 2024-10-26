package racingcar.validator.strategies.carnames;

import java.util.List;
import racingcar.constants.RacingGameConstants;
import racingcar.validator.strategies.ValidationStrategy;
import racingcar.view.ErrorMessage;

public class MaximumCarNameLengthValidator implements ValidationStrategy<List<String>> {

    @Override
    public void validate(List<String> carNames) {
        for (String name : carNames) {
            checkForMaxLength(name);
        }
    }

    private void checkForMaxLength(String name) {
        if (name.length() > RacingGameConstants.MAX_CAR_NAME_LENGTH.getValue()) {
            throw new IllegalArgumentException(ErrorMessage.NAME_TOO_LONG.getMessage());
        }
    }

}
