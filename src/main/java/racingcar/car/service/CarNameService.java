package racingcar.car.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.car.model.Car;

public class CarNameService {

    public List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }

}
