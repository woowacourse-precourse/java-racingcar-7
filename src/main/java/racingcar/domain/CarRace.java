package racingcar.domain;

import static java.util.stream.Collectors.toMap;

import java.util.List;
import java.util.Map;

public class CarRace {

    List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
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
