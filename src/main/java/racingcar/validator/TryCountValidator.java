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
        // 1. null 또는 빈 문자열인지 검증
        notNullOrEmptyValidator.validate(tryCount);

        // 2. 양의 정수인지 검증
        tryCountPositiveIntegerValidator.validate(tryCount);

        // 3. 최대 허용 값을 초과하지 않는지 검증
        tryCountMaximumValidator.validate(tryCount);
    }

}
