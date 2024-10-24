package racingcar.model;

public class Car {
    private final String name;
    private int distance;

    private Car(String name) {
        this.name = name;
    }

    public static Car of(String name) {
        return new Car(name);
    }

    public void move() {
        this.distance++;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public boolean isWinner(int maxDistance) {
        return this.distance == maxDistance;
    }
}
