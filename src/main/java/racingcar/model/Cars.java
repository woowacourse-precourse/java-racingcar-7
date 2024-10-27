package racingcar.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.util.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    private Cars(NumberGenerator numberGenerator, List<String> carNames) {
        validateCarNames(carNames);
        this.cars = createCars(numberGenerator, carNames);
    }

    public static Cars of(NumberGenerator numberGenerator, List<String> carNames) {
        return new Cars(numberGenerator, carNames);
    }

    public void moveAll() {
        cars.forEach(Car::tryMove);
    }

    public Map<String, Integer> status() {
        Map<String, Integer> status = new LinkedHashMap<>();
        cars.forEach(car -> status.put(car.name, car.getPosition()));
        return Collections.unmodifiableMap(status);
    }

    public List<Car> findWinners() {
        return cars.stream()
                .filter(car -> car.compareTo(Collections.max(cars)) == 0)
                .toList();
    }

    private void validateCarNames(List<String> carNames) {
        Set<String> uniqueNames = new HashSet<>(carNames);
        if (carNames.size() != uniqueNames.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> createCars(NumberGenerator numberGenerator, List<String> carNames) {
        return carNames.stream()
                .map(carName -> Car.of(numberGenerator, carName))
                .toList();
    }
}
