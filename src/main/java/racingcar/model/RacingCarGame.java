package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private final List<Car> cars;
    private final int attemptCount;
    private final RandomMoveStrategy moveStrategy;

    public RacingCarGame(List<Car> cars, int attemptCount) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        this.moveStrategy = new RandomMoveStrategy();
    }

    public RacingCarGame(List<Car> cars, int attemptCount, RandomMoveStrategy moveStrategy) {
        this.cars = cars;
        this.attemptCount = attemptCount;
        this.moveStrategy = moveStrategy;
    }

    public void raceEachCar() {
        for (Car car : cars) {
            int randomNumber = moveStrategy.generateRandomNumber();
            if (moveStrategy.isMovable(randomNumber)) {
                car.moveForward();
            }
        }
    }

    public List<String> getWinnerList() {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == findMaxPosition()) {
                winners.add(car.getName());
            }
        }
        return winners;
    }

    public int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }
}
