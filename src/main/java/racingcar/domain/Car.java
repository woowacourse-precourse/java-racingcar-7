package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int RUN_NUMBER = 4;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= RUN_NUMBER) {
            position++;
        }
    }
}
