package racingcar.service;

import static racingcar.constants.CarRaceConstants.MAX_RANDOM_NUMBER;
import static racingcar.constants.CarRaceConstants.MIN_RANDOM_NUMBER;
import static racingcar.constants.CarRaceConstants.MOVE_CRITERIA;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class CarRaceService {
    public void performRaceRound(List<Car> cars) {
        for (Car car : cars) {
            goForward(car);
        }
    }

    private void goForward(Car car) {
        if (isMovable()) {
            car.move();
        }
    }

    private boolean isMovable() {
        if (getRandomNumber() >= MOVE_CRITERIA) {
            return true;
        }
        return false;
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
    }
}
