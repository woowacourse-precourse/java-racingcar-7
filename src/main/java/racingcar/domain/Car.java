package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        int value = Randoms.pickNumberInRange(0, 9);
        if (value >= 4) {
            this.position++;
        }
    }
}
