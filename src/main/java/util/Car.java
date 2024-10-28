package util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import repository.CarRepository;

public class Car {
    public final String name;
    public final ArrayList<Integer> forwardCount;

    public Car(String name) {
        this.name = name;
        this.forwardCount = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getForwardCount(int repeatCount) {
        Integer forwardCount = 0;
        for (int i = 0; i < repeatCount; i++) {
            int number = this.forwardCount.get(i);
            forwardCount += number;
        }
        return forwardCount;
    }

    public void moveForward() {
        this.forwardCount.add(1);
    }

    public void doNotMoveForward() {
        this.forwardCount.add(0);
    }

    public void moveForwardRandomly() {
        if (isMoveAllowed()) {
            moveForward();
            return;
        }
        doNotMoveForward();
    }

    public boolean isMoveAllowed() {
        return pickNumberInRange(0, 9) >= 4;
    }

    public void startRacing() {
        for (int i = 0; i < CarRepository.repeatCount; i++) {
            moveForwardRandomly();
        }
    }
}
