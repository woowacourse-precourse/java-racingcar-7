package racingcar.model;

import java.util.Arrays;
import java.util.List;
import racingcar.util.InputCarsValidator;

public class Cars {

    public List<Car> extractCars(String carNames) {

        InputCarsValidator.isEmpty(carNames);

        List<Car> cars = Arrays.stream(carNames.split(",", -1))
                .map(Car::new)
                .toList();

        InputCarsValidator.hasDuplicate(cars);

        return cars;
    }


}
