package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    public Car(String name) {
        this.name = name;
    }

    public boolean isMove() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            return true;
        }
        return false;
    }
}
