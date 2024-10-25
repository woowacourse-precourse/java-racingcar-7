package util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {
    private String name;
    private int forwardCount;

    public Car(String name, int forwardCount) {
        this.name = name;
        this.forwardCount = forwardCount;
    }

    public String getName() {
        return name;
    }

    public int getForwardCount() {
        return forwardCount;
    }

    private void moveForward() {
        this.forwardCount += 1;
    }

    public void moveForwardRandomly() {
        if (isMoveAllowed()) {
            moveForward();
        }
    }

    private boolean isMoveAllowed() {
        return pickNumberInRange(0, 9) >= 4;
    }
}
