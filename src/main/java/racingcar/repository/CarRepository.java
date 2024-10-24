package racingcar.repository;

import racingcar.domain.Car;

import java.util.List;

public interface CarRepository {
    void save(Car car);
    List<Car> findAll();
}
