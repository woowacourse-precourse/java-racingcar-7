package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private String name;
    private int forwardLevel;

    public Car(String name, int forwardLevel) {
        this.name = name;
        this.forwardLevel = forwardLevel;
    }

    public void tryForwardLevelUp(int randomNumber) {
        if (randomNumber >= 4) {
            forwardLevel++;
        }
    }

    public String getName() {
        return name;
    }
    public int getForwardLevel() {
        return forwardLevel;
    }
}
