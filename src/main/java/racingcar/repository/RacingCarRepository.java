package racingcar.repository;

import racingcar.domain.Car;

import java.util.List;
import java.util.Optional;

public interface RacingCarRepository {
    void addCarByName(String carName);
    Optional<Car> getCarByName(String name);
    List<Car> getCars();
}
