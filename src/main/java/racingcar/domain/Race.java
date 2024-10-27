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

    public List<Car> moveAll() {
        cars.forEach(Car::move);
        return cars;
    }

    public List<Car> findWinners() {
        int maxDistance = getMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    private int getMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
