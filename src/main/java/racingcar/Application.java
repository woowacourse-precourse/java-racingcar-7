package racingcar;

import racingcar.car.RacingCarFactory;
import racingcar.racing.RacingManager;

public class Application {
    public static void main(String[] args) {
        RacingManager racingManager = new RacingManager(new RacingCarFactory());
        racingManager.startRacing();
    }
}
