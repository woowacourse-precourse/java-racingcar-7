package racingcar;

import java.util.List;

public class RacingGame {
    static void playRace(List<Car> cars) {
        for (Car car : cars) {
            car.goForward();
        }
    }

    static void playRace(List<Car> cars, int fixedNumberForTest) {
        for (Car car : cars) {
            car.goForward(fixedNumberForTest);
        }
    }
}

