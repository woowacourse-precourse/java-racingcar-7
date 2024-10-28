package racingcar.model;

import racingcar.exception.ErrorMessage;
import racingcar.utils.RandomGenerator;


public class Round {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;
    private final RandomGenerator randomNumberGenerator;

    public Round(RandomGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void execute(Cars cars) {
        for (Car car : cars.getCars()) {
            int randomValue = randomNumberGenerator.generate();
            validateRandomValue(randomValue);
            if (canMove(randomValue)) {
                car.move();
            }
        }
    }

    private boolean canMove(int randomValue) {
        return randomValue >= MOVE_THRESHOLD;
    }

    private void validateRandomValue(int randomValue) {
        if (!isInRandomRange(randomValue)) {
            throw new IllegalArgumentException(ErrorMessage.RANDOM_VALUE_OUT_OF_BOUNDS.getMessage());
        }
    }

    private boolean isInRandomRange(int randomValue) {
        return randomValue >= RANDOM_MIN && randomValue <= RANDOM_MAX;
    }
}