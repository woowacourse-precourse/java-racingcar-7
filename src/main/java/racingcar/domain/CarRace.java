package racingcar.domain;

import java.util.Arrays;
import java.util.List;

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

    public List<String> getCarsMovingDistance() {
        return cars.stream()
                .map(Car::getMovingDistance)
                .toList();
    }
}
