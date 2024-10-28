package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarNames;

public class CarService {
    public List<Car> createCars(String carsName) {
        CarNames carNames = new CarNames(carsName);
        return carNames.getNames().stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }
}
