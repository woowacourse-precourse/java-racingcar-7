package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        if (CarRacingGame.isMovable()) {
            position++;
        }
    }

    public String getPositionDisplay() {
        return name + " : " + "-".repeat(position);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}