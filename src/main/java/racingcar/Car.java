package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int moveCount;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void move() {
        int move = Randoms.pickNumberInRange(0, 9);

        if(move >= 4) {
            moveCount += 1;
        }
    }
}
