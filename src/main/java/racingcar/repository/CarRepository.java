package racingcar.repository;

import java.util.List;
import racingcar.model.Car;

public interface CarRepository {
    void save(Car car);
    List<Car> findAll();
    List<Car> findWinners();
    List<Car> findByName(String name);
    void reset();
}
