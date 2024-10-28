package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int score = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void move() {
        if (isMove()) {
            score++;
        }
    }

    public boolean isMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
