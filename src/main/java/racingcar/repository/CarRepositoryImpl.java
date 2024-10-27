package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository{
    private final List<Car> cars;

    public CarRepositoryImpl(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

}
