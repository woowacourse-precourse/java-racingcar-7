package racingcar.repository;

import java.util.List;
import racingcar.model.domain.Car;

public interface CarRepository {
    void save(Car car);

    List<Car> findAll();

    void updateAll(List<Car> carList);
}
