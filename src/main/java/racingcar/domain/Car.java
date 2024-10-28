package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int moveCount;


    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void move(int randomNum) {
        if (randomNum >= 4) {
            moveCount += 1;
        }
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }
}
