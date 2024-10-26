package racingcar.domain;

public class Car {
    String name;
    private final StringBuilder distance;

    public Car(String name) {
        this.name = name;
        distance = new StringBuilder();
    }

    public void move() {
        distance.append("-");
    }

    public String getCurrentDistance() {
        return distance.toString();
    }
}
