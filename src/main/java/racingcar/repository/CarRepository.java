package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    private final List<Car> cars = new ArrayList<>();

    public void save(Car car) {
        this.cars.add(car);
    }

    public List<Car> getCars() {
        return this.cars;
    }
}