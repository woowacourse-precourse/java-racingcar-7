package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int moveCount;
    private final MoveStrategy moveStrategy;

    public RacingGame(List<String> carNames, int moveCount, MoveStrategy moveStrategy) {
        validateMoveCount(moveCount);
        this.cars = createCars(carNames);
        this.moveCount = moveCount;
        this.moveStrategy = moveStrategy;
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String name : carNames) {
            carList.add(new Car(name));
        }
        return carList;
    }

    private void validateMoveCount(int moveCount) {
        if (moveCount < 1) {
            throw new IllegalArgumentException("이동 횟수는 1 이상이어야 합니다.");
        }
    }

    public void startRace() {
        for (int i = 0; i < moveCount; i++) {
            moveCars();
            OutputView.printRoundResult(cars);
        }
    }

    private void moveCars() {
        for (Car car : cars) {
            car.move(moveStrategy);
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int max = 0;
        for (Car car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }
}
