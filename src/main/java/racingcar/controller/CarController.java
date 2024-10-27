package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;
import racingcar.model.CarManager;
import racingcar.view.InputView;

import java.util.List;


public class CarController {
    private final int MOVEMENT_STANDARD = 4;
    public boolean canMove() {
        if(Randoms.pickNumberInRange(0,9) >= MOVEMENT_STANDARD) {
            return true;
        }
        return false;
    }

    public void race(List<Car> cars) {
        for(Car car : cars) {
            if(canMove()) {
                car.move();
            }
        }
    }
}
