package racingcar.repository;

import java.util.List;
import racingcar.domain.Car;

public interface CarRepository {
    public void save(Car car);

    public int getNumberOfCars();

    public List<Car> findAll();
}
