package racingcar;

import java.util.List;

public class RacingGame {
    void playRace(List<Car> cars) {
        for (Car car : cars) {
            car.goForward();
        }
    }

    void playRace(List<Car> cars, int fixedNumber) {
        for (Car car : cars) {
            car.goForward(fixedNumber);
        }
    }
}

