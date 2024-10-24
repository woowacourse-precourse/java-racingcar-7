package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_FORWARD = 4;

    private final String name;
    private int movedCount;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int fate = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);

        if (fate >= MOVE_FORWARD) {
            ++this.movedCount;
        }
    }

    public String getName() {
        return this.name;
    }

    public int getMovedCount() {
        return this.movedCount;
    }
}
