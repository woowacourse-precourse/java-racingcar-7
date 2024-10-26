package racingcar.repository;

import java.util.List;
import racingcar.domain.Car;

public interface CarRepository {
    void save(Car car);

    void saveAll(List<Car> cars);

    List<Car> findAll();

    Car findByName(String carName);
}
