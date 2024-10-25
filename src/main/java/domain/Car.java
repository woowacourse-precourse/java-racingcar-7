package domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final Integer MIN_MOVE_COUNT = 4;

    private final String name;
    private int status;

    public Car(final String name) {
        this.name = name;
        this.status = 0;
    }

    public void move() {
        int number = Randoms.pickNumberInRange(0, 9);
        if (number >= MIN_MOVE_COUNT) {
            status++;
        }
    }

    public int getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }
}
