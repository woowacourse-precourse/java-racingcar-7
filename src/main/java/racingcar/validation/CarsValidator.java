package racingcar.validation;

import static racingcar.validation.Exceptions.DUPLICATED_CAR_NAME;
import static racingcar.validation.Exceptions.INSUFFICIENT_CARS;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class CarsValidator implements Validator<List<Car>> {
    private static final int MIN_CARS_AMOUNT = 2;

    @Override
    public void validate(List<Car> cars) {
        validateNameDuplication(cars);
        validateCarsSize(cars);
    }

    private void validateNameDuplication(List<Car> cars) {
        Set<String> uniqueCarNames = new HashSet<>();
        for (Car car : cars) {
            String lowerCarName = car.getName().toLowerCase();
            if (!uniqueCarNames.add(lowerCarName)) {
                throw new IllegalArgumentException(DUPLICATED_CAR_NAME.getMsg());
            }
        }
    }

    private void validateCarsSize(List<Car> cars) {
        if (cars.size() < MIN_CARS_AMOUNT) {
            throw new IllegalArgumentException(INSUFFICIENT_CARS.getMsg());
        }
    }
}
