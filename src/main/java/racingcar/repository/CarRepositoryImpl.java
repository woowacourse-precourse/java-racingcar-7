package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository{
    private List<Car> cars;

    public CarRepositoryImpl() {
        this.cars = new ArrayList<>();
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
