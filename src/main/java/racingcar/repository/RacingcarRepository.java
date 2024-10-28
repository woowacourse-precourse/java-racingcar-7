package racingcar.repository;

import java.util.List;
import racingcar.domain.Car;

public interface RacingcarRepository {
    void save(Car car);

    List<Car> getAllCar();

    boolean existByName(String name);
}
