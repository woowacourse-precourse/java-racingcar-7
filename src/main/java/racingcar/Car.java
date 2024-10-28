package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int goStop;

    public Car(String name, int goStop) {
        this.name = name;
        this.goStop = goStop;
    }
    public String getName() {
        return name;
    }

    public int getGoStop() {
        return goStop;
    }
    public void canMove() {
        if (isCarMove()) goStop++;
    }

    private boolean isCarMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= 4;
    }

}
