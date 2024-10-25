package racingcar.domain.car;

import racingcar.domain.movement.RandomMovement;
import racingcar.domain.random_number.RandomNumber;

public class Car {

    private final CarName carName;
    private final Distance distance;

    //For test only
    public Car(String carName, int distance) {
        this.carName = new CarName(carName);
        this.distance = new Distance(distance);
    }

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.distance = new Distance();
    }

    public void go(RandomMovement randomMovement) {
        if (randomMovement.canGo()) {
            distance.increase();
        }
    }

    public String getCarName() {
        return carName.getCarName();
    }

    public int getDistance() {
        return distance.getDistance();
    }
}
