package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.RandomNumber;

public class RoundService {
    private static final int MOVING_FORWARD = 4;

    public void playRound(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomValue = generateRandomValue();
            moveCarIfNeeded(car, randomValue);

        }
    }

    private int generateRandomValue() {
        return RandomNumber.make();
    }

    private void moveCarIfNeeded(Car car, int randomValue) {
        if (shouldMove(randomValue)) {
            car.forward();
        }
    }


    private boolean shouldMove(int randomValue) {
        if (randomValue >= MOVING_FORWARD) {
            return true;
        }
        return false;
    }
}
