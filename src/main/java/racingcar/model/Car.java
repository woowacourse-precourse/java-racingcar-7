package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private Integer moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public Car(String name, Integer moveCount) {
        this.name = name;
        this.moveCount = moveCount;
    }

    public void moveIfPossible() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            raiseMoveCount();
        }
    }

    public void raiseMoveCount() {
        this.moveCount++;
    }

    public String getName() {
        return name;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}

