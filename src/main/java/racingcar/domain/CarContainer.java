package racingcar.domain;

import java.util.Collections;
import java.util.List;
import racingcar.util.RandomDigitGenerator;
import racingcar.util.RandomGenerator;

public class CarContainer {

    private final RandomGenerator randomGenerator;
    private final List<Car> cars;

    public CarContainer(List<Car> cars) {
        randomGenerator = new RandomDigitGenerator();
        this.cars = cars;
    }

    public void moveAll() {
        cars.forEach(car -> car.moveForward(randomGenerator));
    }

    public List<String> getCurrentRoundResult() {
        return cars.stream()
            .map(Car::toString)
            .toList();
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
