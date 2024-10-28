package racingcar.domain;

import racingcar.utils.RandomUtils;

public class Car {
    private String name;
    private int point;

    public Car(String name) {
        this.name = name;
        this.point = 0;
    }

    public String getName() {
        return name;
    }

    public int getPoint() {
        return point;
    }

    public void tryMove() {
        int randomNumber = RandomUtils.generate();
        if (isSatisfied(randomNumber)) {
            move();
        }
    }

    private void move() {
        this.point++;
    }

    private boolean isSatisfied(int randomNumber) {
        return randomNumber >= 4;
    }
}
