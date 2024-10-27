package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    String carName;
    int currentDistance = 0;

    Car(String name) {
        this.carName = name;
    }

    String getCarName() {
        return carName;
    }

    int getDistance() {
        return currentDistance;
    }

    boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MOVE_THRESHOLD;
    }

    void move() {
        if (canMove()) {
            currentDistance++;
        }
    }

    String getStatus() {
        return getCarName() + " : " + "-".repeat(getDistance());
    }
}
