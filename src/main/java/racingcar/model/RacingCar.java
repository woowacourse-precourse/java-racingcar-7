package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar implements Comparable<RacingCar> {

    private final String name;
    private int moveCount;

    public RacingCar(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public String getMovingState() {
        return "-".repeat(moveCount);
    }

    public void moveOrStop() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            moveCount++;
        }
    }

    @Override
    public int compareTo(RacingCar o) {
        return Integer.compare(o.moveCount, this.moveCount);
    }
}
