package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    public static final String STRING_MARK = "-";

    private final String name;
    private int currentLocation;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void move() {
        currentLocation += pickMoveRange();
    }

    private int pickMoveRange() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num > 4) {
            return 1;
        }
        return 0;
    }

    public String markCarMove(Car car) {
        return STRING_MARK.repeat(Math.max(0, car.getCurrentLocation()));
    }
}
