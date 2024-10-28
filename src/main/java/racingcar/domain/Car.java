package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int START_COUNT = 0;

    private final String name;
    private int winCount;

    public Car(String name) {
        this.name = name;
        this.winCount = START_COUNT;
    }

    public void move(boolean canMove) {
        if (canMove) {
            winCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getWinCount() {
        return winCount;
    }
}
