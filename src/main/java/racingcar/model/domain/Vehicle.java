package racingcar.model.domain;

public abstract class Vehicle {
    private String name;
    private int distance = 0;

    public Vehicle(String name) {
        this.name = name;
    }

    public abstract void move();

    protected abstract int play();

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    protected void incrementDistance(int increment) {
        distance++;
    }
}