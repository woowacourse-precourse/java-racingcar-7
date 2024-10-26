package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constants.Constants.*;

public class Car {

    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
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

    public String getCurrentPosition() {
        return DASH.repeat(position);
    }
}
