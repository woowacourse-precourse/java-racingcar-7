package racingcar.domain;

import racingcar.exception.domain.RaceErrorMessages;
import racingcar.strategy.move.MovementStrategy;
import racingcar.strategy.winner.WinnerStrategy;
import racingcar.view.output.OutputMessages;
import racingcar.view.output.RaceOutput;

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
        System.out.println(OutputMessages.RACE_START);
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.move(movementStrategy.shouldMove());
            }
            System.out.print(RaceOutput.getProgress(this)+OutputMessages.NEW_LINE);
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
        throw new IllegalArgumentException(RaceErrorMessages.CAR_NOT_FOUND.getMessage());
    }

    public List<Car> getWinners() {
        return winnerStrategy.determineWinners(cars);
    }
}