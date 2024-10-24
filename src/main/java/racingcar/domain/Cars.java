package racingcar.domain;

import java.util.Comparator;
import java.util.List;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> win() {
        return findSamePositionCar(getMaxPosition());
    }

    private int getMaxPosition() {
        return getMaxPositionCar().getPosition();
    }

    private Car getMaxPositionCar() {
        return cars.stream()
                .max(Comparator.comparing(Car::getPosition))
                .get();
    }

    private List<Car> findSamePositionCar(int position) {
        return cars.stream()
                .filter(car -> isSamePosition(car, position))
                .toList();
    }

    private boolean isSamePosition(Car car, int maxPosition) {
        return car.getPosition() == maxPosition;
    }
}
