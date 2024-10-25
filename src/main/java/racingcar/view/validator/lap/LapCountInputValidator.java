package racingcar.view.validator.lap;

import static java.util.Objects.nonNull;

abstract class LapCountInputValidator {

    private LapCountInputValidator next = null;

    public LapCountInputValidator doChain(LapCountInputValidator validator) {
        this.next = validator;
        return validator;
    }

    public void check(String source) {
        if (nonNull(next)) {
            next.check(source);
        }
    }
}
