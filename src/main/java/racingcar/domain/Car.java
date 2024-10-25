package racingcar.domain;

public class Car {
    private String name;
    private int currentPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void moveOrStop(MovementDecider movementDecider) {
        if (movementDecider.isMoveable()) {
            currentPosition++;
        }
    }
}
