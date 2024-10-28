package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    String carName;
    int distance;

    Car(String name) {
        this.carName = name;
    }

    String getCarName() {
        return carName;
    }

    int getDistance() {
        return distance;
    }

    boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MOVE_THRESHOLD;
    }

    void move() {
        if (canMove()) {
            distance++;
        }
    }

    String getStatus() {
        return getCarName() + " : " + "-".repeat(getDistance());
    }
}
