package racingcar.domain;

import java.util.List;
import racingcar.util.RandomGenerator;

public class CarContainer {

    private final List<Car> cars;

    public CarContainer(List<Car> cars) {
        this.cars = cars;
    }

    public void moveAll(RandomGenerator randomGenerator) {
        cars.forEach(car -> car.moveForward(randomGenerator.generate()));
    }

    public List<String> getCurrentRoundResult() {
        return cars.stream().map(Car::toString).toList();
    }

    public List<Car> getCars() {
        return cars.stream()
                .map(Car::copy)
                .toList();
    }
}
