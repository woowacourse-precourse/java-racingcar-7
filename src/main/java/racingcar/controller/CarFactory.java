package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarFactory {
    public List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }
}