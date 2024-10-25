package racingcar.model.policy;

import racingcar.model.Car;
import racingcar.model.RandomNumberGenerator;

public class RandomForwardMovementPolicy implements MovementPolicy {

    RandomNumberGenerator randomNumberGenerator;

    public RandomForwardMovementPolicy(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    @Override
    public void move(Car car) {
        if (isMovable()) {
            int currentPosition = car.getPosition();
            car.move(currentPosition + 1);
        }
    }

    private boolean isMovable() {
        int randomNumber = randomNumberGenerator.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
