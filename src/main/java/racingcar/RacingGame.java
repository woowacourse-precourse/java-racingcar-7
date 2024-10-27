package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class RacingGame {
    private final List<Car> cars;
    private final int runLimit;

    public RacingGame(List<Car> cars, int runtLimit) {
        this.cars = cars;
        this.runLimit = runtLimit;
    }

    public void run() {
        for (int i = 0; i < runLimit; i++) {
            for (Car car : cars) {
                int number = Randoms.pickNumberInRange(0, 9);
                car.moveForward(number);
            }
        }
    }
}
