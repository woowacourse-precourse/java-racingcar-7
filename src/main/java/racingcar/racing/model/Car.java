package racingcar.racing.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int totalDistance;

    public Car(String name) {
        this.name = name;
        this.totalDistance = 0;
    }

    public int movedDistance() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public void updateTotalDistance() {
        this.totalDistance++;
    }

    public String getName() {
        return name;
    }

    public int getTotalDistance() {
        return totalDistance;
    }
}
