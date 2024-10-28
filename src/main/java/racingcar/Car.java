package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;

    public int getMoveCount() {
        return moveCount;
    }

    public String getName() {
        return name;
    }

    private int moveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            moveCount += 1;
        }
    }

    public void print() {
        System.out.print(name + " : ");
        for (int cnt_i = 0; cnt_i < moveCount; cnt_i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
