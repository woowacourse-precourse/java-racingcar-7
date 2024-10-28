package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public final class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void attemptMove() {
        if (canMove()) {
            position++;
        }
    }

    private boolean canMove() {
        return (Randoms.pickNumberInRange(0, 9) >= 4);
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
