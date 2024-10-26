package racingcar.domain;

import racingcar.exception.domain.RaceErrorMessage;
import racingcar.strategy.move.MovementStrategy;
import racingcar.strategy.winner.WinnerStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Race {
    private final List<Car> cars;
    private final int attemptCount;
    private final MovementStrategy movementStrategy;
    private final WinnerStrategy winnerStrategy;

    public Race(Set<String> carNames, int attemptCount, MovementStrategy movementStrategy, WinnerStrategy winnerStrategy) {
        this.cars = createCars(carNames);
        this.attemptCount = attemptCount;
        this.movementStrategy = movementStrategy;
        this.winnerStrategy = winnerStrategy;
    }

    private List<Car> createCars(Set<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    public void start() {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.move(movementStrategy.shouldMove());
            }
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public int getCarPosition(String carName) {
        for (Car car : cars) {
            if (car.getName().equals(carName)) {
                return car.getPosition();
            }
        }
        throw new IllegalArgumentException(RaceErrorMessage.CAR_NOT_FOUND.getMessage());
    }

    public List<Car> getWinners() {
        return winnerStrategy.determineWinners(cars);
    }
}