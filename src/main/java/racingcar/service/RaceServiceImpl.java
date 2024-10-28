package racingcar.service;

import racingcar.domain.Car;

import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceServiceImpl implements RaceService {

    @Override
    public void race(List<Car> cars) {
        for (Car car : cars) {
            moveForwardOrStop(car);
        }
    }

    private void moveForwardOrStop(Car car) {
        if (canMoveForward()) {
            car.move();
        }
    }

    private boolean canMoveForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }
}
