package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Car {

    private String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            moveCount++;
        }
    }

    public boolean hasSameMoveCount(int moveCount) {
        return this.getMoveCount() == moveCount;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }


}
