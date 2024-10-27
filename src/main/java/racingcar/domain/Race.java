package racingcar.domain;

import java.util.List;
import java.util.stream.Stream;

public class Race {

    private final List<Car> cars;
    private final NumberGenerator numberGenerator;

    public Race(String rawCarNames, NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.cars = parseCarNames(rawCarNames);
    }

    private List<Car> parseCarNames(String rawCarNames) {
        return Stream.of(rawCarNames.split(","))
                .map(String::trim)
                .map(carName -> new Car(carName, numberGenerator))
                .toList();
    }

    public void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    public List<Car> findWinners() {
        int maxDistance = cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    public List<Car> getCars() {
        return cars;
    }
}
