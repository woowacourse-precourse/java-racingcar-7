package racingcar.util.validator;

import racingcar.constant.ErrorType;

public class RacingCarStringValidator implements StringValidator {

    @Override
    public void validateLength(final String value, final int maxLength) {
        if (isExceedCarNameLength(value, maxLength)) {
            throw new IllegalArgumentException(ErrorType.EXCEEDED_MAX_CAR_NAME_LENGTH);
        }
    }

    @Override
    public void validateFormat(final String value) {
        if (value.isBlank() || value.isEmpty()) {
            throw new IllegalArgumentException(ErrorType.INVALID_CAR_NAME);
        }
    }

    private static boolean isExceedCarNameLength(final String name, final int maxLength) {
        return name.length() > maxLength;
    }
}
