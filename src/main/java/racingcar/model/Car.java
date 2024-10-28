package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move() {
        if (!isMoved()) {
            return;
        }
        distance += 1;
    }

    public Boolean isMoved() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
