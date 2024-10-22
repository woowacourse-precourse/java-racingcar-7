package racingcar;

import racingcar.utils.RandomUtils;

public class Car {
    private final String name;
    private int currentMoveCount;

    public Car(String name, int currentMoveCount) {
        this.name = name;
        this.currentMoveCount = 0;
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

    private boolean isMoveForwardPossible(int number) {
        return number >= 4;
    }
}
