package racingcar.factory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class CarsFactory {
    private static final String CAR_NAMES_DELIMITER = ",";
    private static final int SPLIT_NO_LIMIT = -1;

    public static Cars createCars(String carNamesInput) {
        List<Car> cars = transferStringToCars(carNamesInput);
        return new Cars(cars);
    }

    private static List<Car> transferStringToCars(String carNamesInput) {
        return Arrays.stream(carNamesInput.split(CAR_NAMES_DELIMITER, SPLIT_NO_LIMIT))
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
