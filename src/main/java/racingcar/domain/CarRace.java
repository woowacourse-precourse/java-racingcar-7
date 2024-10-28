package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class CarRace {
    private final Cars cars;
    private final Attempts attempts;

    public CarRace(Cars cars, Attempts attempts) {
        this.cars = cars;
        this.attempts = attempts;
    }

    public void runRace() {
        cars.getCars().forEach(Car::move);
    }

    public List<String> getWinners() {
        int maxPosition = cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.getCars().stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
