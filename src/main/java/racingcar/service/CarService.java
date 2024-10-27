package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.RaceCar;

public class CarService {

    public List<Car> createCars(String input) {
        List<String> items = List.of(input.split(","));
        return items.stream()
                .map(RaceCar::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
