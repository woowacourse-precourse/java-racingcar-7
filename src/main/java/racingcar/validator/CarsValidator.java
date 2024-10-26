package racingcar.validator;

import racingcar.constant.ErrorMessage;
import racingcar.model.Car;

import java.util.List;

public class CarsValidator {
    public static final int MAX_CAR_UNITS = 5;

    private CarsValidator() {}

    public static void validateCars(List<Car> cars) {
        if (cars.stream().distinct().count() != cars.size()) {
            throw new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.CAR_NAME_CANNOT_DUPLICATE);
        } // end if

        if (cars.size() > MAX_CAR_UNITS) {
            throw  new IllegalArgumentException(ErrorMessage.PREFIX + ErrorMessage.MAX_CAR_UNITS_IS_FIVE);
        } // end if
    } // validateCars
} // class