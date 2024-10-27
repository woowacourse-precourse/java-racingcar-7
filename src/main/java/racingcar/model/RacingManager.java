package racingcar.model;

import java.util.List;

public class RacingManager {

    public void playRounds(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            moveCars(cars);
            displayPositions(cars);
            System.out.println();
        }
    }

    private void moveCars(List<Car> cars) {
        for (Car car : cars) {
            car.attemptMoveForward();
        }
    }

    private void displayPositions(List<Car> cars) {
        for (Car car : cars) {
            car.displayPosition();
        }
    }
}
