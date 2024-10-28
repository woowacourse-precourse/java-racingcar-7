package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position; // 전진한 횟수

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (shouldMove()) {
            position++;
        }
    }

    private boolean shouldMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}

