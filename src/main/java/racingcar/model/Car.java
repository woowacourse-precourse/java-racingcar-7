package racingcar.model;

public class Car {

    private final String name;
    private int moveDistance = 0;

    public Car(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void increaseDistance() {
        this.moveDistance++;
    }
}
