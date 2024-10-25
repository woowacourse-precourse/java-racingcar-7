package racingcar.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class CarFactory {

    public static List<Car> createCars(String carNames) {
        return parseCarNames(carNames);
    }

    private static List<Car> parseCarNames(String carNames){
        return Arrays.stream(carNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());
    }

}
