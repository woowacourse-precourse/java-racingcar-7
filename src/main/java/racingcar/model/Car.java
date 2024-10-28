package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int position = 0;
    private static final int MOVE_THRESHOLD = 4;
    private Randoms randoms;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

}
