package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private final List<Car> cars;
    private final int lapCount;

    public CarRace(List<Car> cars, int lapCount) {
        this.cars = cars;
        this.lapCount = lapCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getLapCount() {
        return lapCount;
    }

    public List<Car> findCarsByPosition(int position) {
        return cars.stream()
                .filter(car -> car.getPosition() == position)
                .toList();
    }

    public int findMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
