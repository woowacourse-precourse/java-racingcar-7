package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GameService {
    private final ArrayList<Car> cars;

    public GameService(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public ArrayList<Car> getWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
