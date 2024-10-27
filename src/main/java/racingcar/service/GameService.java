package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;

public class GameService {
    private final ArrayList<Car> cars;

    public GameService(ArrayList<Car> cars) {
        this.cars = cars;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalStateException::new);
    }
}
