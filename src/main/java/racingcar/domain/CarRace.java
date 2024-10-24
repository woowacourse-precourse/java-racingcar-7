package racingcar.domain;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CarRace {

    List<Car> cars;

    public CarRace(String carNames) {
        this.cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }

    public Map<String, String> getCarsNameAndMovingDistance() {
        return cars.stream()
                .collect(toMap(
                        Car::getName,
                        Car::getMovingDistance
                ));
    }
}
