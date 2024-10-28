package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.exceptions.InvalidInputException;
import racingcar.model.car.Car;
import racingcar.model.car.RaceCar;

public class RaceCarService implements CarService {

    public List<Car> createCars(String input) {
        if (input.isEmpty()) {
            throw new InvalidInputException();
        }

        List<String> items = List.of(input.split(","));
        return items.stream()
                .map(RaceCar::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
