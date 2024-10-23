package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Race;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingCarService {

    public void raceCars(List<Car> cars) {
        for (Car car: cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.moveIfPossible(randomNumber);
        }
    }
}
