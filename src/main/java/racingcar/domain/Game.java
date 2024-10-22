package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;


public class Game {
    private final List<Car> carList;

    public Game(final List<Car> carList) {
        this.carList = carList;
    }

    public void moveForward() {
        for (Car car : carList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                car.moveForward();
            }
        }
    }

}
