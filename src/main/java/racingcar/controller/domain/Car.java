package racingcar.controller.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getName() {
        return name;
    }
}
