package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void tryMoveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (RacePolicy.canMoveForward(randomNumber)) {
            moveForward();
        }
    }

    private void moveForward() {
        position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
