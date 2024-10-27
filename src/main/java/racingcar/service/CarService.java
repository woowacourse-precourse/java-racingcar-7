package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.utils.Util;

public class CarService {
    public List<Car> createCars(String carsName) {
        return Util.splitByComma(carsName).stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
