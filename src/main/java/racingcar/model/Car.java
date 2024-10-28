package racingcar.model;


import static racingcar.validation.ValidatorFactory.buildFactory;

import racingcar.service.AcceleratorService;
import racingcar.validation.Validator;
import racingcar.validation.ValidatorFactory;

public class Car {
    private final String name;
    private Integer currentPosition;

    private Car(String name, Integer currentPosition) {
        validate(name);
        this.name = name;
        this.currentPosition = currentPosition;
    }

    public static Car ofStartingPoint(String name) {
        return new Car(name, 0);
    }

    public void move(AcceleratorService accelerator) {
        if (accelerator.canMoveForward()) {
            currentPosition++;
        }
    }

    private void validate(String value) {
        ValidatorFactory validatorFactory = buildFactory();
        Validator validator = validatorFactory.getValidator(this.getClass());
        validator.validate(value);
    }

    public String getName() {
        return name;
    }

    public Integer getCurrentPosition() {
        return currentPosition;
    }
}