package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class CarMemoryRepository implements CarRepository {

    private List<Car> cars = new ArrayList<>();

    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public int getNumberOfCars() {
        return cars.size();
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }
}
