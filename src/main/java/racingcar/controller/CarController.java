package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarController {

    public List<String> splitCarNames(String input) {
        List<String> carNames = Arrays.stream(input.split(",")).toList();
        return carNames;
    }

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
