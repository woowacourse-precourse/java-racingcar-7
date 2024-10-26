package racingcar;

import java.util.Random;

public class Car {

    private String name;
    private int currentPosition;

    public void moveForward() {
        currentPosition += 1;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}

