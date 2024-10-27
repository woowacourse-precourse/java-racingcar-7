package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MINIMUM_MOVE_THRESHOLD = 4;
    private static final int MIN_RANDOM_NUMBER = 0;
    private static final int MAX_RANDOM_NUMBER = 9;

    private String name;
    private int moveDistance;

    protected Car(String name) {
        this.name = name;
        this.moveDistance = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER) >= MINIMUM_MOVE_THRESHOLD) {
            moveDistance ++;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
