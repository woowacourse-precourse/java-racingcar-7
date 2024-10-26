package racingcar.domain;

import java.util.List;

public class Race {
    private final Round round;
    private final List<Car> cars;
    private final MoveCondition moveCondition;

    public Race(Round round, List<Car> cars, MoveCondition moveCondition) {
        this.round = round;
        this.cars = cars;
        this.moveCondition = moveCondition;
    }

    public List<Car> proceed() {
        // TODO: 중복호출방지

        moveAllCars();

        if (round.hasNext()) {
            round.next();
        }

        return cars;
    }

    private void moveAllCars() {
        cars.forEach(this::moveCar);
    }

    private void moveCar(Car car) {
        if (moveCondition.isSatisfied()) {
            car.move();
        }
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
