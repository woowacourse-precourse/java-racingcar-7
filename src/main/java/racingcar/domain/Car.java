package racingcar.domain;

import static racingcar.utils.RandomMoveUtils.createRandomNumber;
import static racingcar.utils.RandomMoveUtils.isMoving;

public class Car {
    private final String name;
    private int advanceNum;

    public Car(String name) {
        this.name = name;
        this.advanceNum = 0;
    }

    public void moveOrStop() {
        if (isMoving(createRandomNumber())) {
            advanceNum++;
        }
    }

    public void getStatus() {
        System.out.println(name + " : " + "-".repeat(advanceNum));
    }

    public int getAdvanceNum() {
        return advanceNum;
    }
}
