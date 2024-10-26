package racingcar.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import racingcar.util.NumberGenerator;

public class Racing {
    private final List<Car> cars;
    private int attempt;

    private Racing(NumberGenerator numberGenerator, List<String> carNames, int attempt) {
        validateCarNames(carNames);
        this.cars = createCars(numberGenerator, carNames);
        validateAttempt(attempt);
        this.attempt = attempt;
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

    private void validateAttempt(int attempt) {
        if (attempt <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public static Racing of(NumberGenerator numberGenerator, List<String> carNames, int attempt) {
        return new Racing(numberGenerator, carNames, attempt);
    }

    public void makeAttempt() {
        validateAttempt(attempt);
        this.attempt--;
        cars.forEach(Car::tryMove);
    }

    public boolean isFinish() {
        return attempt == 0;
    }

    public Map<String, Integer> status() {
        Map<String, Integer> status = new LinkedHashMap<>();
        cars.forEach(car -> status.put(car.name, car.getPosition()));
        return Collections.unmodifiableMap(status);
    }

    public List<String> winnersNames() {
        return cars.stream()
                .filter(car -> car.compareTo(Collections.max(cars)) == 0)
                .map(car -> car.name)
                .toList();
    }
}
