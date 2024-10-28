package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    private List<Car> cars;
    private RandomMoveStrategy moveStrategy;

    public RacingCarGame() {
        this.cars = new ArrayList<>();
        this.moveStrategy = new RandomMoveStrategy();
    }

    public void forceRandomMoveStrategy(RandomMoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public void initialize(List<Car> carList) {
        this.cars = carList;
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
}
