package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.GameConstants;

public class Car {

    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar(int randomNum) {
        if (randomNum >= GameConstants.MOVING_FORWARD) {
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
