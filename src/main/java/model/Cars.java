package model;

import util.randomnumber.RandomNumberHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(String::trim)
                .map(Car::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    public void moveAll(RandomNumberHandler randomNumberHandler) {
        for (Car car : cars) {
            if (randomNumberHandler.canMove()) {
                car.moveForward();
            }
        }
    }

    public List<String> getWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
