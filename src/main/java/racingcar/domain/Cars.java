package racingcar.domain;

import java.util.List;
import racingcar.utils.RandomGenerator;

public class Cars {
    private final List<Car> cars;
    private final RandomGenerator randomGenerator;

    public Cars(List<Car> cars, RandomGenerator randomGenerator) {
        this.cars = cars;
        this.randomGenerator = randomGenerator;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void moveAll() {
        cars.forEach(car -> car.move(randomGenerator.generate()));
    }

    public List<Car> getWinners() {
        return cars.stream()
                .filter(car -> car.getPosition() == getMaxPosition())
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
