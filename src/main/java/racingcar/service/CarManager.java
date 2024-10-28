package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarManager {
    private List<Car> cars = new ArrayList<>();

    public void createCars(List<String> carNames) {
        carNames.stream()
                .map(Car::new)
                .forEach(cars::add);
    }

    public List<Car> getCars() {
        return cars;
    }
}
