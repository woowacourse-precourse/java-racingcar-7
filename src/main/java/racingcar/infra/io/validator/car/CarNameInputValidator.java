package racingcar.infra.io.validator.car;

abstract class CarNameInputValidator {

    private CarNameInputValidator next = null;

    public void doChain(CarNameInputValidator validator) {
        this.next = validator;
    }

    public void check(String source) {
        if (next != null) {
            next.check(source);
        }
    }
}
