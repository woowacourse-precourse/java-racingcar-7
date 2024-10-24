package racingcar;

import java.util.List;

public class RacingGame {
    void playRace(List<Car> cars, int attemptCount) {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.goForward();
            }
        }
    }

    void playRace(List<Car> cars, int attemptCount, int fixedNumber) {
        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                car.goForward(fixedNumber);
            }
        }
    }
}
