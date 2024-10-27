package racingcar.model;

import java.util.List;
import java.util.Map;

public class Racing {
    private final Cars cars;
    private int attempt;

    private Racing(Cars cars, int attempt) {
        this.cars = cars;
        validateAttempt(attempt);
        this.attempt = attempt;
    }

    public static Racing of(Cars cars, int attempt) {
        return new Racing(cars, attempt);
    }

    public void makeAttempt() {
        validateAttempt(attempt);
        this.attempt--;
        cars.moveAll();
    }

    public boolean isFinish() {
        return attempt == 0;
    }

    public Map<String, Integer> status() {
        return cars.status();
    }

    public List<String> winnersNames() {
        return cars.findWinners().stream()
                .map(car -> car.name)
                .toList();
    }

    private void validateAttempt(int attempt) {
        if (attempt <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
