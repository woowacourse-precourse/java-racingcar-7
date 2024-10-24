package racingcar.domain;

import java.util.List;

public class Race {
    private final List<Car> cars;
    private final GenerateNumberStrategy numberStrategy;

    public Race(List<Car> cars, GenerateNumberStrategy numberStrategy) {
        this.cars = cars;
        this.numberStrategy = numberStrategy;
    }

    public void moveAllCars() {
        cars.forEach(car ->
                car.move(numberStrategy.generate())
        );
    }

    public List<Car> getWinner() {
        int maxMovement = getMaxMovement();
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    private int getMaxMovement() {
        return cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElse(0);
    }
}
