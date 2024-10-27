package racingcar.vehicle;

import racingcar.util.RandomGenerator;
import racingcar.vehicle.Vehicle;

public class Car extends Vehicle {

    private RandomGenerator randomGenerator = new RandomGenerator();

    public Car(String carName, int tryCount) {
        super(carName,tryCount);
    }

    @Override
    public void moveForward() {
        if (tryCount > 0) {
            if (randomGenerator.getRandomNumber() >= 4) {
                this.forwardCount++;
                this.tryCount--;
            }
        }
    }

}
