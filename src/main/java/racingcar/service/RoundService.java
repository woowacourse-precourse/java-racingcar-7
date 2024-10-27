package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;

public class RoundService {
    private static final int MOVING_FORWARD = 4;

    public void playRound(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomValue = RandomNumber.make();
        }
    }
}
