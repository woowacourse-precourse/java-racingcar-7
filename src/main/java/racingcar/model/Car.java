package racingcar.model;

public class Car {
    private final String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
        movedDistance = 0;
    }


    public void move() {
        this.movedDistance += 1;
    }

    public String getName() {
        return this.name;
    }

    public int getMovedDistance() {
        return this.movedDistance;
    }
}
