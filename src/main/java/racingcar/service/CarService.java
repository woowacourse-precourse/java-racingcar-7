package racingcar.service;

import java.util.List;
import racingcar.model.car.Car;

public interface CarService {
    List<Car> createCars(String input);
}
