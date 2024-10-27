package racingcar.domain;

import static racingcar.constant.CarConstants.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;

    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = DEFAULT_DISTANCE;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
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
        return Randoms.pickNumberInRange(RANDOM_NUMBER_RANGE_MIN_VALUE, RANDOM_NUMBER_RANGE_MAX_VALUE)
                >= MOVE_FOWARD_CONDITION_MIN_VALUE;
    }
}
