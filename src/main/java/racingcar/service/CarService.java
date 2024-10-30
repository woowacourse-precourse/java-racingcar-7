package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public interface CarService {

    void register(Car car);

    List<Car> getAllCars();
}
