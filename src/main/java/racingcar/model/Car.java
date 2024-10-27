package racingcar.model;

import racingcar.utils.Utils;

public class Car {
    private static final int DEFAULT_POSITION = 0;

    private String name;
    private int position;

    Car(String name) {
        this.name = name;
        this.position = DEFAULT_POSITION;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveBasedOnPoint(int point) {
        if (Utils.isAtLeastFour(point)) {
            position++;
        }
    }
}
