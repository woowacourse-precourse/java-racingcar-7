package racingcar.domain;

import java.util.List;

public interface CarFactory {
    Car createCar(String name);

    List<Car> createCars(List<String> carNames);
}
