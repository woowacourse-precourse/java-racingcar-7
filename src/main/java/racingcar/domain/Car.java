package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private int distance;

    public void move() {
        if (canMove()) {
            distance++;
        }
    }

    private static boolean canMove() {
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
