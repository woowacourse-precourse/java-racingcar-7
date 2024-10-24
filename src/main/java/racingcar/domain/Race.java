package racingcar.domain;

import java.util.List;

public class Race {
    private final Round round;
    private final List<Car> cars;
    private final GenerateNumberStrategy numberStrategy;

    public Race(Round round, List<Car> cars, GenerateNumberStrategy numberStrategy) {
        this.round = round;
        this.cars = cars;
        this.numberStrategy = numberStrategy;
    }

    public List<Car> proceed() {
        if (!round.hasNext()) {
            throw new IllegalArgumentException();
        }
        moveAllCars();
        round.next();
        return cars;
    }

    private void moveAllCars() {
        cars.forEach(car ->
                car.move(numberStrategy.generate())
        );
    }

    public List<Car> getWinner() {
        if (round.hasNext()) {
            throw new IllegalArgumentException();
        }

        int maxMovement = getMaxMovement();
        return cars.stream()
                .filter(car -> car.getMovement() == maxMovement)
                .toList();
    }

    public boolean isGameEnd() {
        return !round.hasNext();
    }

    private int getMaxMovement() {
        return cars.stream()
                .mapToInt(Car::getMovement)
                .max()
                .orElse(0);
    }
}
