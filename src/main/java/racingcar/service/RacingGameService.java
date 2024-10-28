package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.List;

public class RacingGameService {
    private final List<Car> cars = new ArrayList<>();

    public void createCars(String input) {
        String[] carNames = input.split(",");

        for (String name : carNames) {
            cars.add(new Car(name.trim()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }
}
