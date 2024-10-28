package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int forwardCount;
    private static final int MOVE_THRESHOLD = 4;

    public Car(String name) {
        this.name = name;
        this.forwardCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    public void moveForwardByRandom() {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) forwardCount++;
    }
}
