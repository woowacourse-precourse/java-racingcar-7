package racingcar.vehicle;

import racingcar.util.RandomGenerator;
import racingcar.vehicle.Vehicle;

public class Car extends Vehicle {

    private RandomGenerator randomGenerator = new RandomGenerator();

    public Car(String carName, int tryCount) {
        super(carName,tryCount);
    }

    @Override
    public void attemptMoveForward() {
        if (tryCount > 0) {
            int randomNumber = randomGenerator.getRandomNumber();

            if(randomNumber < 0 || randomNumber > 9)
                throw new IllegalArgumentException("허용되지 않는 랜덤 숫자 범위입니다.");

            if (randomNumber >= 4) {
                this.forwardCount++;
                this.tryCount--;
            }
        }
    }

}
