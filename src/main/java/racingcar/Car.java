package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    String carName;
    int distance;

    Car(String name) {
        this.carName = name;
        this.distance = 0;
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

    // 테스트용으로만 사용
    void setDistance(int distance) {
        this.distance = distance;
    }
}
