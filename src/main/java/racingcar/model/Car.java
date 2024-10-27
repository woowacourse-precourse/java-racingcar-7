package racingcar.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.io.Serializable;

public class Car {
    private String name;
    private int position;

    private Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public static Car create(String name) {
        return new Car(name);
    }

    static int randomNumberGenerator() {
        int randomNumber = pickNumberInRange(0, 9);
        return randomNumber;
    }

    public void move(int i) {
        if (i >= 4) {
            // 전진
            position += 1;
        } else {
            return;
        }
    }

    public int getPosition() {
        return position;
    }
}
