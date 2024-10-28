package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingGame {
    private static final int FORWARD_THRESHOLD = 4;
    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = cars;
    }

    public void race() {
        for (Car car : cars) {
            moveForward(car);
        }
    }

    private void moveForward(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= FORWARD_THRESHOLD) {
            car.move();
        }
    }
}