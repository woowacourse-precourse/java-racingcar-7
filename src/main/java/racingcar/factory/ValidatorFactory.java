package racingcar.factory;

import racingcar.model.Cars;
import racingcar.validation.CarsValidator;
import racingcar.validation.Validator;

public class ValidatorFactory {
    public static Validator<Cars> createCarsValidator() {
        return new CarsValidator();
    }
}
