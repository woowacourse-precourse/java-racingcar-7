package racingcar;

import java.util.Collections;
import java.util.List;

public class CarCollection {

    private final List<Car> cars;

    private CarCollection(List<Car> cars) {
        this.cars = cars;
    }

    public static CarCollection of(List<Car> cars) {
        return new CarCollection(cars);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void move() {
        cars.forEach(Car::move);
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }
}
