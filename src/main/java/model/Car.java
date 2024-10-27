package model;

public class Car {

    private int value = 0;
    private final String name;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public void move(int distance) {
        value += distance;
    }
}
