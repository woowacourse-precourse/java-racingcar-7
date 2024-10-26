package racingcar.factory;

import racingcar.domain.Cars;
import racingcar.validation.CarsValidator;
import racingcar.validation.Validator;

public class ValidatorFactory {
    public static Validator<Cars> createCarsValidator() {
        return new CarsValidator();
    }
}
