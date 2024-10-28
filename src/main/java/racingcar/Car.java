package racingcar;

public class Car {
    private final String name;
    private int racingPosition;

    Car(String name) {
        this.name = name;
        racingPosition = 0;
    }

    public String getName() {
        return name;
    }

    public int getRacingPosition() {
        return racingPosition;
    }

    public void moveOnePosition() {
        racingPosition += 1;
    }
}
