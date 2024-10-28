package racingcar.model;

import java.util.Objects;
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

    public boolean isSameName(String otherName) {
        return Objects.equals(name, otherName);
    }

    public boolean isSameProgress(int otherProgress) {
        return progress == otherProgress;
    }

    public String getName() {
        return name;
    }

    public int getProgress() {
        return progress;
    }
}
