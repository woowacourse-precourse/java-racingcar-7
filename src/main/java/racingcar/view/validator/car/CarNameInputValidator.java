package racingcar.view.validator.car;

import static java.util.Objects.nonNull;

abstract class CarNameInputValidator {

    private CarNameInputValidator next = null;

    public void doChain(CarNameInputValidator validator) {
        this.next = validator;
    }

    public void check(String source) {
        if (nonNull(next)) {
            next.check(source);
        }
    }
}
