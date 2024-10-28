package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<Car> cars;
    private int roundCount;

    public void initialize(String carNames, int roundCount) {
        this.cars = createCars(carNames);
        this.roundCount = roundCount;
    }

    private List<Car> createCars(String carNames) {
        return List.of(carNames.split(","))
                .stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void moveAllCars() {
        cars.forEach(Car::move);
    }

    public List<String> getCarStates() {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.toList());
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public int getRoundCount() {
        return roundCount;
    }
}