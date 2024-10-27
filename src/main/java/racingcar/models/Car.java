package racingcar.models;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private int distance;
    private String name;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void incrementDistance() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            this.distance++;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getDistance() {
        return this.distance;
    }

}