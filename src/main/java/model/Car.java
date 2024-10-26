package model;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final static int MOVE_STEP = 1;
    private final static int RANDOM = 4;

    private final String name;
    private int step;

    public Car(String name) {
        this.name = name;
        this.step = 0;
    }

    public void randomMove() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);

        if (isMoreThanFour(randomNumber)) {
            step += MOVE_STEP;
        }
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

    private boolean isMoreThanFour(int num) {
        return num >= RANDOM;
    }

}
