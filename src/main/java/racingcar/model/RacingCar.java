package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {
    private String carName;
    private Integer moveCount;

    public RacingCar(String carName) {
        this.carName = carName;
        moveCount = 0;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0,9) == 4){
            moveCount += 1;
        }
    }

    public String getName() {
        return carName;
    }

    public Integer getMoveCount() {
        return moveCount;
    }
}
