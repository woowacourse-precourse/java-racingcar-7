package racingcar.model;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::create)
                .toList();
    }

    public static Cars apply(List<String> carNames) {
        return new Cars(carNames);
    }

    public void playARound() {
        for (Car car : cars) {
            moveOrNot(car);
        }
    }

    private void moveOrNot(Car car) {
        if (car.pickRandomNumber() >= 4) {
            car.moveForward();
        }
    }

    public List<String> findWinners() {
        return cars.stream()
                .filter(car -> car.isSameLocation(findWinnerLocation()))
                .map(Car::getName)
                .toList();
    }

    private int findWinnerLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

    public List<String> getStatus() {
        return cars.stream()
                .map(Car::makeStatusResult)
                .toList();
    }
}
