package racingcar.factory;

import racingcar.domain.Car;
import racingcar.validation.CarValidator;
import racingcar.validation.Validator;

public class CarFactory {
    private static final Validator<String> validator = new CarValidator();

    public static Car createCar(String carName) {
        validator.validate(carName);
        return new Car(carName);
    }
}
