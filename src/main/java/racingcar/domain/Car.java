package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private int position = 0;

    public static final int GO_NUMBER = 4;

    public Car(String name) {
        this.name = name;
    }

    public void go() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= GO_NUMBER;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
