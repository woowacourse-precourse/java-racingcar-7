package racingcar.model;

import racingcar.util.MovementDecider;

public class Car {
    private final String name;
    private int progress;

    public Car(String name) {
        this.name = name;
        progress = 0;
    }

    public void tryMove() {
        if (MovementDecider.tryMove()) {
            progress ++;
        }
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }
}
