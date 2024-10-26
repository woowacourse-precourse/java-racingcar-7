package racingcar.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.util.NumberGenerator;

public class Racing {
    private int attempt;
    private final List<Car> cars;

    public static Racing of(NumberGenerator numberGenerator, int attempt, List<String> carNames) {
        return new Racing(numberGenerator, attempt, carNames);
    }

    private Racing(NumberGenerator numberGenerator, int attempt, List<String> carNames) {
        this.attempt = attempt;
        this.cars = createCars(numberGenerator, carNames);
    }

    private List<Car> createCars(NumberGenerator numberGenerator, List<String> carNames) {
        return carNames.stream()
                .map(carName -> Car.of(numberGenerator, carName))
                .toList();
    }

    public void race() {
        this.attempt--;
        cars.forEach(Car::tryMove);
    }

    public boolean isFinished() {
        return attempt == 0;
    }

    public Map<String, Integer> getStatus() {
        Map<String, Integer> status = new LinkedHashMap<>();
        cars.forEach(car -> status.put(car.getName(), car.getPosition()));
        return Collections.unmodifiableMap(status);
    }

    public List<String> getWinnersNames() {
        return cars.stream()
                .filter(car -> car.compareTo(Collections.max(cars)) == 0)
                .map(Car::getName)
                .toList();
    }
}
