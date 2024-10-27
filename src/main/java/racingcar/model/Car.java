package racingcar.model;

public class Car {
    private String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        movedDistance++;
    }

    public int getMovedDistance() {
        return movedDistance;
    }

    public String getName() {
        return name;
    }
}
