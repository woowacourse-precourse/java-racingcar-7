package racingcar.repository;

import racingcar.domain.Car;

import java.util.List;
import java.util.Optional;

public interface CarRepository {
    Car save(Car car);

    Optional<Car> findByName(String name);

    List<Car> findAll();
}
