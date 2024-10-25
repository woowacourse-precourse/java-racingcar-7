package util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;

public class Car {
    private String name;
    private ArrayList<Integer> forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getForwardCount(int repeatCount) {
        Integer forwardCount = 0;
        for (int i = 0; i < repeatCount; i++) {
            int number = this.forwardCount.get(i);
            forwardCount += number;
        }

        return forwardCount;
    }

    private void moveForward() {
        this.forwardCount.add(1);
    }

    private void doNotMoveForward() {
        this.forwardCount.add(0);
    }

    public void moveForwardRandomly() {
        if (isMoveAllowed()) {
            moveForward();
            return;
        }

        doNotMoveForward();
    }

    private boolean isMoveAllowed() {
        return pickNumberInRange(0, 9) >= 4;
    }

    public void startRacing(int repeatCount) {
        for (int i = 0; i < repeatCount; i++) {
            moveForwardRandomly();
        }
    }
}
