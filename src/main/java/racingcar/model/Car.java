package racingcar.model;

public class Car {
    private String name;
    private int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public Car(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    public void move() {
        distance += 1;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public Car clone() {
        return new Car(this.name, this.distance);
    }
}
