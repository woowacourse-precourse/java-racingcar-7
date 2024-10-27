package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final String name;
    private long moveCount;

    public Car(String name) {
        this.name = name;
        this.moveCount = 0;
    }

    public void tryMove() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) {
            moveCount++;
        }
    }
}
