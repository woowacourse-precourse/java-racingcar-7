package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;
    private static final int MINIMUM_MOVE_VALUE = 4;

    public Car(String name, int position) {
        this.name = name;
        this.position = 0;
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
