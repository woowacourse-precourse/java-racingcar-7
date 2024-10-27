package racingcar.controller;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarController {

    public List<String> splitCarNames(String input) {
        List<String> carNames = Arrays.stream(input.replaceAll(" ","").split(",")).toList();
        validateCarNames(carNames);
        return carNames;
    }

    public void validateCarNames(List<String> carNames) {
        if (carNames.size() > 5) {
            throw new IllegalArgumentException("자동차는 5대까지만.");
        }
        if (carNames.size() != carNames.stream().distinct().count()) {
            throw new IllegalArgumentException("중복 자동차가 있어요.");
        }
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
