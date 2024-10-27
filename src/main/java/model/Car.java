package model;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private final String name;
    private int position = INITIAL_POSITION;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void moveForward() {
        position++;
    }
}
