package racingcar.validation;

import static racingcar.validation.Exceptions.DUPLICATED_CAR_NAME;
import static racingcar.validation.Exceptions.INSUFFICIENT_CARS;

import java.util.HashSet;
import java.util.Set;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsValidator implements Validator<Cars>{
    private static final int MIN_CARS_AMOUNT = 2;

    @Override
    public void validate(Cars cars) {
        validateNameDuplication(cars);
        validateCarsSize(cars);
    }

    private void validateNameDuplication(Cars cars) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (Car car : cars.getCars()) {
            if (!uniqueCarNames.add(car.getName())) {
                throw new IllegalArgumentException(DUPLICATED_CAR_NAME.getMsg());
            }
        }
    }

    private void validateCarsSize(Cars cars) {
        if (cars.getCars().size() < MIN_CARS_AMOUNT) {
            throw new IllegalArgumentException(INSUFFICIENT_CARS.getMsg());
        }
    }
}
