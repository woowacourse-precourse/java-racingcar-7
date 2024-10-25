package racingcar.repository;

import java.util.List;
import racingcar.domain.Car;

public interface CarRepository {

    void save(Car car);

    Car findByName(String name);

    List<Car> findAll();
}
