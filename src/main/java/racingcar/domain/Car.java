package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    public static final int DEFAULT_DISTANCE = 0;
    public static final int RANDOM_NUMBER_RANGE_MIN_VALUE = 0;
    public static final int RANDOM_NUMBER_RANGE_MAX_VALUE = 9;
    public static final int MOVE_FOWARD_CONDITION_MIN_VALUE = 4;

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
