package racingcar;

import racingcar.utils.RandomUtils;

public class Car {
    private final String name;
    private int currentMoveCount = 0;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward() {
        int randomNumber = RandomUtils.getRandomNumber(0, 9);
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
