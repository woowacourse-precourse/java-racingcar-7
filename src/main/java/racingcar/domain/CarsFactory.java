package racingcar.domain;

import static racingcar.domain.ErrorMessage.CAR_NAME_DUPLICATE;
import static racingcar.domain.ErrorMessage.INPUT_CAR_EMPTY;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CarsFactory {
    private final static String CAR_NAME_DELIMITER = ",";

    public Cars registerCars(String input) {
        validateEmptyCarName(input);
        Set<Car> cars = new HashSet<>();

        for (Car car : getParsedCar(input)) {
            if (!cars.add(car)) {
                throw new IllegalArgumentException(CAR_NAME_DUPLICATE.getMessage());
            }
        }
        return new Cars(cars);
    }

    private List<Car> getParsedCar(String carNames) {
        List<Car> result = new ArrayList<>();
        String[] splitWord = carNames.split(CAR_NAME_DELIMITER);

        for (String s : splitWord) {
            result.add(new Car(s.trim()));
        }
        return result;
    }


    private static void validateEmptyCarName(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(INPUT_CAR_EMPTY.getMessage());
        }
    }

}
