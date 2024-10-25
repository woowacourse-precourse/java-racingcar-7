package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import racingcar.domain.Car;

public class CarService {

    public List<Car> createCars(Set<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        return cars;
    }
}
