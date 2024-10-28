package racingcar.repository;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class RacingcarRepositoryImpl implements RacingcarRepository {
    private final List<Car> cars;

    public RacingcarRepositoryImpl() {
        cars = new ArrayList<>();
    }

    @Override
    public void save(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> getAllCar() {
        return this.cars;
    }

    @Override
    public boolean existByName(String name) {
        for (Car car : cars) {
            if (car.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
