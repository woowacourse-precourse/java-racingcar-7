package racingcar.model;


import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 9;
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveCar() {
        int randomNum = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
        if (randomNum >= MOVE_THRESHOLD) {
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
