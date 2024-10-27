package racingcar.model;

import racingcar.util.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;

    public Race(List<String> carNames) {
        this.cars = createCars(carNames);
    }

    public void startRace(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            raceOnce();
        }
    }

    private void raceOnce() {
        cars.forEach(car -> car.moveIfPossible(RandomNumberGenerator.generate()));
    }

    private List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public List<Car> getCars() {
        return cars;
    }
}
