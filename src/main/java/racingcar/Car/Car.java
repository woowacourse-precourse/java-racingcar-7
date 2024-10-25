package racingcar.Car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final CarName carName;
    private Position position;

    public Car(CarName carName) {
        this.carName = carName;
        this.position = new Position(0);
    }

    public CarName getName() {
        return carName;
    }

    public Position getPosition() {
        return position;
    }

    public void moveForward() {
        if (getRandomValue() >= 4) {
            position = new Position(position.getValue() + 1);
        }
    }

    private int getRandomValue() {
        return Randoms.pickNumberInRange(0,9);
    }
}

