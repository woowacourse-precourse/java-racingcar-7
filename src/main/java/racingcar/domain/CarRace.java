package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    private final List<Car> cars;

    public CarRace(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
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
