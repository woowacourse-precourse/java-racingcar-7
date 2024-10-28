package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constants.GameConstants;

public class Car {

    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        int randomNum = Randoms.pickNumberInRange(GameConstants.RANDOM_MIN, GameConstants.RANDOM_MAX);
        if (randomNum >= GameConstants.MOVE_THRESHOLD) {
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
