package racingcar.fake;

import racingcar.util.validator.StringValidator;

public class FakeStringValidator implements StringValidator {

    @Override
    public void validateFormat(final String value) {
        // fake
    }

    @Override
    public void validateLength(final String value, final int maxLength) {
        // fake
    }
}
