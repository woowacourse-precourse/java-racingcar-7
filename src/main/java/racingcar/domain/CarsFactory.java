package racingcar.domain;

import static racingcar.domain.ErrorMessage.CAR_NAME_DUPLICATE;
import static racingcar.domain.ErrorMessage.INPUT_CAR_EMPTY;

import java.util.HashSet;
import java.util.Set;

public class CarsFactory {
    private final static String CAR_NAME_DELIMITER = ",";

    public Cars registerCars(String input) {
        validateEmptyCarName(input);
        Set<Car> result = new HashSet<>();

        for (String carName : input.split(CAR_NAME_DELIMITER)) {
            Car car = new Car(carName.trim());

            validateDuplicateCar(result, car);
            result.add(car);
        }
        return new Cars(result);
    }

    private static void validateDuplicateCar(Set<Car> cars, Car car) {
        if (cars.contains(car)) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE.getMessage());
        }
    }

    private static void validateEmptyCarName(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_CAR_EMPTY.getMessage());
        }
    }

}
