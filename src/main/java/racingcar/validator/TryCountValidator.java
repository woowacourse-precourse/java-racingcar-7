package racingcar.validator;

import racingcar.validator.strategies.trycount.TryCountMaximumValidator;
import racingcar.validator.strategies.trycount.TryCountNotNullOrEmptyValidator;
import racingcar.validator.strategies.trycount.TryCountPositiveIntegerValidator;

public class TryCountValidator {
    private final TryCountNotNullOrEmptyValidator notNullOrEmptyValidator;
    private final TryCountPositiveIntegerValidator tryCountPositiveIntegerValidator;
    private final TryCountMaximumValidator tryCountMaximumValidator;

    public TryCountValidator() {
        this.notNullOrEmptyValidator = new TryCountNotNullOrEmptyValidator();
        this.tryCountPositiveIntegerValidator = new TryCountPositiveIntegerValidator();
        this.tryCountMaximumValidator = new TryCountMaximumValidator();
    }

    public void validate(String tryCount) {
        notNullOrEmptyValidator.validate(tryCount);
        tryCountPositiveIntegerValidator.validate(tryCount);
        tryCountMaximumValidator.validate(tryCount);
    }

}
