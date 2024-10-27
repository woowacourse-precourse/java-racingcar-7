package racingcar.controller;

import racingcar.Car;

import java.util.ArrayList;
import java.util.List;

public class CarController {
    public Car createSingleCar(String carName) {
        Car car = new Car(carName, 0);
        return car;
    }

    public List<Car> createAllCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            cars.add(createSingleCar(carName));
        }

        return cars;
    }
}
