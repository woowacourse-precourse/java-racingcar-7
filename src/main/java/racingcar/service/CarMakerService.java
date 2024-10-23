package racingcar.service;

import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class CarMakerService {

    public List<Car> makeCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(new Car(carName));
        }

        return cars;
    }
}
