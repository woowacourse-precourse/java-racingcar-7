package racingcar;

public class Car {
    private final String name;
    private int moveDistance;

    public Car(String name, int moveDistance) {
        this.name = name;
        this.moveDistance = moveDistance;
    }

    public void moveOneStep() {
        this.moveDistance += 1;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }
}
