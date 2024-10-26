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

    public String getCurrentRoundResult() {
        List<String> currentCarResult = cars.stream()
            .map(Car::toString)
            .toList();

        return String.join("", currentCarResult);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
