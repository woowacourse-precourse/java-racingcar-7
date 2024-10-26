package racingcar.domain;

import racingcar.utils.RandomMoveUtils;

import static racingcar.utils.RandomMoveUtils.createRandomNumber;

public class Car {
    private final String name;
    private int advanceNum;

    public Car(String name) {
        this.name = name;
        this.advanceNum = 0;
    }

    public void moveOrStop() {
        if (RandomMoveUtils.isMoving(createRandomNumber())) {
            advanceNum++;
        }
    }

    public void getStatus() {
        System.out.println(name + " : " + "-".repeat(advanceNum));
    }
}
