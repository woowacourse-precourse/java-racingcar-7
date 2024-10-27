package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Car;

public class MoveController {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
    }

    public void setMoveInformation(Car car) {
        car.setPosition(1);
    }
}
