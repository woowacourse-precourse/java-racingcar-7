package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Vehicle {
    protected String name;
    protected int position;

    public Vehicle(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public void move () {
        int moveAmount = Randoms.pickNumberInRange(0, 9);
        if (moveAmount >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
