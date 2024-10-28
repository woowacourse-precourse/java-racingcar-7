package racingcar.service;


import racingcar.domain.Car;

import java.util.List;

public class WinnerDeterminer {
    private final List<Car> cars;

    public WinnerDeterminer(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> determineWinner() {
        int maxPosition = getMaxPositionInCars();
        return getCarsAtMaxPosition(maxPosition);
    }

    private int getMaxPositionInCars() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    private List<Car> getCarsAtMaxPosition(int maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }
}
