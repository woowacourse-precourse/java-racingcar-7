package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int location;

    public Car(final String name) {
        this.name = name;
        this.location = 0;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }

    public void plusLocation() {
        this.location += 1;
    }

    public boolean isMove() {
        return pickNumber() >= 4;
    }

    private static int pickNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }
}
