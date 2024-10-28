package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int ADVANCE_THRESHOLD = 4;

    private final String name;
    private int distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void attemptMove() {
        if (Randoms.pickNumberInRange(0, 9) >= ADVANCE_THRESHOLD) {
            move();
        }
    }

    public void move() {
        this.distance++;
    }

    public String getPosition() {
        return "-".repeat(distance);
    }
}
