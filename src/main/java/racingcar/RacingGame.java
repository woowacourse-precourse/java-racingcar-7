package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RacingGame {
    private ArrayList<Car> cars;
    private int tryCount;

    public RacingGame(ArrayList<Car> cars, int tryCount) {
        this.cars = cars;
        this.tryCount = tryCount;
    }

    public void start() {
        for (int i = 0; i < tryCount; i++) {
            determineCarsMovement(cars);
        }
    }

    private void determineCarsMovement(ArrayList<Car> cars) {
        for (Car car : cars) {
            determineCarMovement(car);
        }
    }

    private void determineCarMovement(Car car) {
        int randomNumber = Randoms.pickNumberInRange(Constant.RANDOM_START, Constant.RANDOM_END);
        if (randomNumber >= Constant.MOVE_FORWARD) {
            car.move();
        }
    }
}
