package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    private final List<String> winningCars = new ArrayList<>();

    public Winner(final List<Car> cars) {
        calculateWinningCars(cars);
    }

    private void calculateWinningCars(List<Car> cars) {
        int maxDistance = calculateMaxDistance(cars);
        cars.stream()
                .filter(car -> car.getMoveDistance() == maxDistance)
                .map(Car::getName)
                .forEach(winningCars::add);
    }

    private int calculateMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getMoveDistance)
                .max()
                .getAsInt();
    }

    public List<String> getWinningCars() {
        return winningCars;
    }
}
