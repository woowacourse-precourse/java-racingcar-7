package racingcar.model;

public class Car {

    private String name;
    private int currentPosition;

    public Car(String name) {
        this.name = name;
    }

    public void moveForward(int distance) {
        currentPosition += distance;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }
}