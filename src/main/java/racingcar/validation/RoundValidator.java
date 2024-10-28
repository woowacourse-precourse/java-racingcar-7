package racingcar.validation;

import racingcar.constant.ErrorMessage;
import racingcar.model.Round;

public class RoundValidator implements Validator {
    @Override
    public Class<?> supportsType() {
        return Round.class;
    }

    @Override
    public void validate(Object target) {
        String roundInput = (String) target;
        try {
            int rounds = Integer.parseInt(roundInput);
            if (rounds <= 0) {
                throw new IllegalArgumentException(ErrorMessage.MINIMUM_ROUND_ERROR);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_TYPE_ERROR);
        }
    }
}
