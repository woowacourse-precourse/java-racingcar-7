package racingcar.model;

public class Car {

    private String name;
    private int movedDistance;

    public Car(String name) {
        this.name = name;
        this.movedDistance = 0;
    }

    public String getName() {
        return name;
    }

    public int getMovedDistance() {
        return movedDistance;
    }
}
