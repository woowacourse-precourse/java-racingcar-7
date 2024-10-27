package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String carName;
    int currentDistance = 0;

    Car(String name) {
        this.carName = name;
    }

    String getCarName() {
        return carName;
    }

    boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

    void move() {
        if (canMove()) {
            currentDistance++;
        }
    }

    String getStatus() {
        return getCarName() + " : " + "-".repeat(currentDistance);
    }

    int getPosition() {
        return currentDistance;
    }

}
