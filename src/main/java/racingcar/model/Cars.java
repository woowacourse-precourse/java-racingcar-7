package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void incrementCarPosition(Car car) {
        car.incrementPosition();
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = findMaxPosition();
        return findCarsAtPosition(maxPosition);
    }

    private int findMaxPosition() {
        return cars.stream().mapToInt(Car::getPosition).max().orElse(0);
    }

    private List<Car> findCarsAtPosition(int position) {
        return cars.stream().filter(car -> car.getPosition() == position).toList();
    }
}
