package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int moves = 0;
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public boolean isMovable() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber >= 4;
    }
}
