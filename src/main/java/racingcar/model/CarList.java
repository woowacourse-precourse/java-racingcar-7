package racingcar.model;

import java.util.List;

public class CarList {
    private final List<Car> cars;

    public CarList(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }
}
