package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.model.Car;

public class RacingService {

    public void race(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (shouldMove()) {
                car.move();
            }
        }
    }

    public boolean shouldMove() {
        if (Randoms.pickNumberInRange(0, 9) > 3) {
            return true;
        }
        return false;

    }

    public void printCarStatus(ArrayList<Car> cars) {
        for(Car car : cars) {
            System.out.println(car.getStatus());
        }
    }
}
