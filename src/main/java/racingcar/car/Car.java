package racingcar.car;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int currentMoveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public Car(String name, int currentMoveCount) {
        this.name = name;
        this.currentMoveCount = currentMoveCount;
    }

    public void moveForward() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (isMoveForwardPossible(randomNumber)) {
            this.currentMoveCount++;
        }
    }

    public String getName() {
        return name;
    }

    public int getCurrentMoveCount() {
        return currentMoveCount;
    }

    private boolean isMoveForwardPossible(int number) {
        return number >= 4;
    }
}
