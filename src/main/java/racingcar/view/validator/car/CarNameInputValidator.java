package racingcar.view.validator.car;

import static java.util.Objects.nonNull;

abstract class CarNameInputValidator {

    private CarNameInputValidator next = null;

    public CarNameInputValidator doChain(CarNameInputValidator validator) {
        this.next = validator;
        return validator;
    }

    public void check(String source) {
        if (nonNull(next)) {
            next.check(source);
        }
    }
}
