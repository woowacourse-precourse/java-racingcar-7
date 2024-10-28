package racingcar.validator;

import static racingcar.error.ErrorMessageConstants.DUPLICATE_CAR_NAME;
import static racingcar.error.ErrorMessageConstants.NULL_CAR_IN_LIST;
import static racingcar.error.ErrorMessageConstants.NULL_CAR_LIST;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.domain.car.Car;

public class RaceValidator {

    public static void validate(List<Car> cars) {
        validateNullInCars(cars);
        validateCarsDuplicate(cars);
    }

    private static void validateNullInCars(List<Car> cars) {
        if (cars == null) {
            throw new IllegalArgumentException(NULL_CAR_LIST);
        }
        if (cars.contains(null)) {
            throw new IllegalArgumentException(NULL_CAR_IN_LIST);
        }
    }

    private static void validateCarsDuplicate(List<Car> cars) {
        Set<String> carNameSet = new HashSet<>();
        for (Car car : cars) {
            if (!carNameSet.add(car.getName())) {
                String errorMessage = String.format(DUPLICATE_CAR_NAME, car.getName());
                throw new IllegalArgumentException(errorMessage);
            }
        }
    }
}