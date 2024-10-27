package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final Name name;
    private int position;

    public Car(Name carName) {
        this.name = carName;
        position = 0;
    }

    public void incrementPosition() {
        position += 1;
    }

    public void moveForward() {
        int randomValue = Randoms.pickNumberInRange(0, 9);

        if (randomValue >= 4) {
            incrementPosition();
        }
    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }
}
