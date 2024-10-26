package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int START_NUMBER = 0;
    private static final int END_NUMBER = 9;
    private static final int MIN_NUMBER = 4;

    private final String name;
    private int advanceCount;

    public Car(String name) {
        this.name = name;
    }

    public void attemptAdvance() {
        if (Randoms.pickNumberInRange(START_NUMBER, END_NUMBER) >= MIN_NUMBER) {
            advanceCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getAdvanceCount() {
        return advanceCount;
    }
}
