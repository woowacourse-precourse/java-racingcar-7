package racingcar.validator;

import racingcar.constants.ValidationConstants;

public class RacingCarRepeatCountValidator {

    public void validateRepeatCountNumberFormat(String inputCarRacingRepeatCount) {
        try {
            int count = Integer.parseInt(inputCarRacingRepeatCount);
            if (count <= 0) {
                throw new IllegalArgumentException(ValidationConstants.REPEAT_COUNT_NOT_POSITIVE);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ValidationConstants.REPEAT_COUNT_NOT_INTEGER);
        }
    }
}
