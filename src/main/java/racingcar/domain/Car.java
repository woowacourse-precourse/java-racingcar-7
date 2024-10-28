package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    String name;
    int position;

    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveOrStand() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            move();
        }
    }

    public void move() {
        this.position++;
    }
}
