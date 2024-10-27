package racingcar.fake;

import racingcar.util.validator.NumberValidator;

public class fakeNumberValidator implements NumberValidator<Integer> {

    @Override
    public void validateFormat(final String value) {
        // fake
    }

    @Override
    public void validateRange(final Integer value, final Integer maxValue) {
        // fake
    }
}
