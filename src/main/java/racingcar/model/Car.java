package racingcar.model;

import racingcar.constant.AppConstants;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int randomValue) {
        if (randomValue >= AppConstants.MOVE_THRESHOLD) {
            position++;
        }
    }
}