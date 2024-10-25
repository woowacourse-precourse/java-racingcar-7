package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = carNames.stream().map(Car::new).toList();
        return cars;
    }


}
