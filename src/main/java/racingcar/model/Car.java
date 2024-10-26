package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
        this.movedDistance = 0;
    }

    public void attemptMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            this.movedDistance++;
        }
    }

    public boolean isWinner(int winnerMovedDistance) {
        return this.movedDistance == winnerMovedDistance;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
