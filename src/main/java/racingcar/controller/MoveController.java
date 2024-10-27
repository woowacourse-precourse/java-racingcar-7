package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.util.Limit;

public class MoveController {
    public int createRandomNumber() {
        return Randoms.pickNumberInRange(Limit.MIN_NUMBER.getValue(), Limit.MAX_NUMBER.getValue());
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= Limit.ALLOW_MOVE.getValue();
    }

    public void setMoveInformation(Car car) {
        car.setPosition(Limit.SINGLE_DISTANCE.getValue());
    }
}
