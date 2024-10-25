package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class RacingCar {

    private final String name;
    private int forwardCount;

    public RacingCar(String name) {
        this.name = name;
    }

    void move() {
        int pickedNumber = Randoms.pickNumberInRange(0, 9);
        if (canMoveForward(pickedNumber)) {
            forwardCount++;
        }
    }

    static boolean canMoveForward(int pickedNumber) {
        return pickedNumber >= 4;
    }

    String getName() {
        return name;
    }

    int getForwardCount() {
        return forwardCount;
    }
}
