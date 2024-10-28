package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;
    private static final int MINIMUM_MOVE_VALUE = 4;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MINIMUM_MOVE_VALUE;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
