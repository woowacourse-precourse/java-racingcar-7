package racingcar.model.domain;

public abstract class Vehicle {
    private String name;
    private int distance;

    public Vehicle(String name,int distance) {
        this.name = name;
        this.distance = distance;
    }

    public abstract boolean move(int raceScore);

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