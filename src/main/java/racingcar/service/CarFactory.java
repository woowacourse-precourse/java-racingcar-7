package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.validator.Validator;

public class CarFactory {

    public static List<Car> createCars(String carNames) {
        List<Car> cars = parseCarNames(carNames);
        Validator.validateCarNames(cars);
        return cars;
    }

    private static List<Car> parseCarNames(String carNames){
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
