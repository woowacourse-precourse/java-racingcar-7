package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int START_POSITION = 0;
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = START_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void attemptMoveForward() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            position++;
        }
    }

    public void displayPosition() {
        System.out.println(getName() + " : " + "-".repeat(position));
    }
}
