package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String carName;
    protected Integer moveCount;

    public RacingCar(String carName) {
        this.carName = carName;
        moveCount = 0;
    }

    public void move() {
        if (getRandomInteger() >= 4) {
            moveCount += 1;
        }
    }

    protected int getRandomInteger() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public String getName() {
        return carName;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
