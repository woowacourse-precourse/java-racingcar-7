package racingcar.racing.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car implements Comparable<Car> {
    private final String name;
    private int totalDistance;

    public Car(String name) {
        this.name = name;
        this.totalDistance = 0;
    }

    Car(String name, int currentDistance) {
        this.name = name;
        this.totalDistance = currentDistance;
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

    @Override
    public int compareTo(Car o) {
        if (this.totalDistance > o.totalDistance) {
            return -1;
        }
        if (this.totalDistance == o.totalDistance) {
            return 0;
        }
        return 1;
    }
}
