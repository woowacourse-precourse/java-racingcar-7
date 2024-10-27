package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;

    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public String toStringCarPosition(Car car) {
        return String.format("%s : %s%n", car.getName(), "-".repeat(car.getDistance()));
    }

    public void moveForward() {
        if (canMoveForward()) {
            increaseDistance();
        }
    }

    public void increaseDistance() {
        distance++;
    }

    private boolean canMoveForward() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
