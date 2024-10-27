package racingcar.model;

import java.util.List;

public class RacingManager {

    public void playRounds(List<Car> cars, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            for (Car car : cars) {
                car.attemptMoveForward();
            }
        }
    }
}
