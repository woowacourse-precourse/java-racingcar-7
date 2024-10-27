package racingcar.util.validator;

import java.util.regex.Pattern;
import racingcar.constant.ErrorType;

public class RacingCarNumberValidator implements NumberValidator<Integer> {

    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d*");

    @Override
    public void validateFormat(final String value) {
        if (isNotNumber(value)) {
            throw new IllegalArgumentException(ErrorType.INVALID_COUNT);
        }
    }

    @Override
    public void validateRange(final Integer value, final Integer maxValue) {
        if (isExceedMaxValueRange(value, maxValue)) {
            throw new IllegalArgumentException(ErrorType.EXCEEDED_MAX_COUNT);
        }
    }

    private boolean isExceedMaxValueRange(final Integer value, final Integer maxValue) {
        return value > maxValue;
    }

    private boolean isNotNumber(final String value) {
        return !NUMBER_PATTERN.matcher(value).matches();
    }
}
