package racingcar.validator;


import racingcar.validator.strategies.trycount.NotNullOrEmptyTryCountValidator;
import racingcar.validator.strategies.trycount.PositiveIntegerValidator;

public class TryCountValidator {
    private final NotNullOrEmptyTryCountValidator notNullOrEmptyValidator;
    private final PositiveIntegerValidator positiveIntegerValidator;

    public TryCountValidator() {
        this.notNullOrEmptyValidator = new NotNullOrEmptyTryCountValidator();
        this.positiveIntegerValidator = new PositiveIntegerValidator();
    }

    public void validate(String tryCount) {
        notNullOrEmptyValidator.validate(tryCount);
        positiveIntegerValidator.validate(tryCount);
    }

}
