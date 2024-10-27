package racingcar.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if(isMovable()) {
            position++;
        }
    }

    protected boolean isMovable() {
        return pickNumberInRange(0, 9) >= 4;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
